package cqupt.interviewQ.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-05-15 9:52
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        // case1
//        new Thread(new HoldLockThread("A锁", "B锁"), "AAA").start();
//        new Thread(new HoldLockThread("B锁", "A锁"), "BBB").start();// 由于String的不可变行,会产生死锁
        
        // case2
//        new Thread(new HoldLockThread(new Student(1,"A"), new Student(2,"B"))).start();// 这种方式不会产生死锁
//        new Thread(new HoldLockThread(new Student(2,"B"), new Student(1,"A"))).start();// 因为这相当于创建了四个student实例

        // case3 使用相同的实例会产生死锁
        Student a = new Student(1, "A");
        Student b = new Student(2, "B");
        new Thread(new HoldLockThread(a, b)).start();
        new Thread(new HoldLockThread(b, a)).start();
    }
}
class HoldLockThread implements Runnable {
    private Student lockA;
    private Student lockB;

    public HoldLockThread(Student lockA, Student lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {// 两个线程都瞬间进入到这里,根据构造的参数不同,AAA线程先拿到A锁,BBB线程先拿到B锁
            System.out.println(Thread.currentThread().getName() + " 已经拿到了" + lockA + "尝试去拿" + lockB);
            try {
                TimeUnit.SECONDS.sleep(2);// 此处sleep就是为了AAA拿到A锁,BBB拿到B锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + " 已经拿到了" + lockB + "尝试去拿" + lockA);
            }
        }
    }
}

