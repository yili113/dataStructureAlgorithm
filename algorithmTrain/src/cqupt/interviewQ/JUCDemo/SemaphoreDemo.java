package cqupt.interviewQ.JUCDemo;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-05-05 15:00
 * Semaphore的锁是可以复用的,有进有出
 * 多个线程抢多个资源
 * 模拟6个车抢3个车位
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);// 模拟三个停车位
        for (int i = 1; i <= 6 ; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();// 车抢到车位
                    System.out.println(Thread.currentThread().getName() + "号车抢到车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + "号车离开车位");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();// 车离开车位,释放了cpu资源
                }
            }, String.valueOf(i)).start();
        }
    }
}
