package cqupt.interviewQ.JUCDemo;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Liyi
 * @create 2020-05-05 11:49
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙");
        });

        for (int i = 1; i <= 7 ; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "号龙珠集齐");
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
