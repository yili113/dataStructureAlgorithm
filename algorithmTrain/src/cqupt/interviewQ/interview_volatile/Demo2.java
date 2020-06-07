package cqupt.interviewQ.interview_volatile;

import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-05-14 13:11
 * 验证volatile的可见性
 */
public class Demo2 {
    public static void main(String[] args) {
        seeIsOk();
        notAtom();
    }

    private static void notAtom() {
        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.add();// 20个线程每个线程低number加100次
                }
            }, String.valueOf(i)).start();
        }
//        try {
//            TimeUnit.SECONDS.sleep(4);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        while(Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(myData.number);// 用main线程查看最终number值
        // 最终的number肯定要与 20*1000,说明有的线程add方法被加塞了,说明volatile不保证原子性
    }

    private static void seeIsOk() {
        MyData myData = new MyData();// 线程操作资源
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "is coming");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "has modify number");
        }, "t1").start();

        while (myData.number == 0) {
            // 只要number是0,main线程就在这等着
        }
        System.out.println(Thread.currentThread().getName() + "感知到了number变化");
    }
}
class MyData{
    volatile static int number = 0;
    public void addTo60() {
        this.number = 60;
    }
    public synchronized void add() {
        this.number ++;
    }
}
