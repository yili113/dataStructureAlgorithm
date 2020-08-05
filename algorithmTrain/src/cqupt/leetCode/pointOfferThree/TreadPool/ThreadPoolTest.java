package cqupt.leetCode.pointOfferThree.TreadPool;

import java.util.concurrent.*;

/**
 * @author yiLi
 * @create 2020-08-05 15:23
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 100L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(),  new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 1; i <= 8; i++) {// 模拟8个线程
                final int temp = i;
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "号线程处理" + temp + "号任务");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            threadPoolExecutor.shutdown();// 如果没有在finally中写shutdown()线程池会一直存在,程序也就不会停止
        }
    }
}
