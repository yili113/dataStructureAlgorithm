package cqupt.interviewQ.threadPool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yiLi
 * @create 2020-06-09 19:47
 */
public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService sec = Executors.newScheduledThreadPool(5);
        sec.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(8000);
                    System.out.println(System.currentTimeMillis() / 1000);// 以秒为单位进行打印
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);// period任务调度周期


        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
