package cqupt.interviewQ;

import java.util.concurrent.CountDownLatch;

/**
 * @author Liyi
 * @create 2020-05-05 11:06
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {

//        closeDoor();
        CountDownLatch cdl = new CountDownLatch(3);
        for (int i = 1; i <= 3 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国被消灭");
                cdl.countDown();// 计数-1
            }, CountryEnum.forEach_Country(i).getRetMessage()).start();
        }
        try {
            cdl.await();// 除非计数到0,不然一直等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "秦国一统天下");
    }

    private static void closeDoor() {
        CountDownLatch cdl = new CountDownLatch(5);
        for (int i = 1; i <= 5 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "号同学已离开教室");
                cdl.countDown();// 计数-1
            }, String.valueOf(i)).start();
        }
        try {
            cdl.await();// 除非计数到0,不然一直等待
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "班长可以关门了");
    }
}
