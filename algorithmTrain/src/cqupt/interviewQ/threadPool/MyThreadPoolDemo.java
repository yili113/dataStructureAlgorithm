package cqupt.interviewQ.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Liyi
 * @create 2020-05-06 10:33
 */
public class MyThreadPoolDemo {
    /**
     * 测试：
     * 如果正在运行的线程数量大于或等于corePoolSize，那么将这个任务放入队列
     * 如果这个时候队列满了且正在运行的线程数量还是小于maximumPoolSize，那么还是要创建非核心线程`立即`运行这个任务
     * @param args
     */
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 5, 100L, TimeUnit.SECONDS,// core为2,max为5
                new LinkedBlockingQueue<>(3),// 模拟候客区只有三个位置
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        try {
            for (int i = 1; i <= 6 ; i++) {// 模拟6个顾客来办理业务，最大窗口只有5个
                final int temp = i;
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "号窗口" + "服务顾客" + temp + "号");
                    try {
                        TimeUnit.SECONDS.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPoolExecutor.shutdown();
        }
    }
}
