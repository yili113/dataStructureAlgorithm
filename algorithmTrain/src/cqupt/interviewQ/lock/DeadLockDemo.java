package cqupt.interviewQ.lock;

import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-05-15 9:52
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        new Thread(new HoldLockThread("A锁", "B锁"), "AAA").start();
        new Thread(new HoldLockThread("B锁", "A锁"), "BBB").start();
    }
}
class HoldLockThread implements Runnable {
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
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

