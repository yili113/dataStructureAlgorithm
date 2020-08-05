package cqupt.leetCode.pointOfferThree.TreadPool;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author yiLi
 * @create 2020-08-05 15:37
 * 1.Callable执行任务用submit()  这个方法向线程池提交任务有返回值
 * 2.submit()返回的任务类型是Future类型,用该类的get()方法拿到返回值
 * 3.线程池在finally{}中一定要shutdown()
 */
public class CallableTest {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 
                100L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3), new ThreadPoolExecutor.AbortPolicy());
        ArrayList<Future<String>> futures = new ArrayList<>();
        try {
            for (int i = 1; i <= 10; i++) {
                Future<String> future = threadPoolExecutor.submit(new MyCallable());
                futures.add(future);
            }
            for (Future<String> stringFuture : futures) {
                System.out.println(new Date() + stringFuture.get());
            }
        }catch (Exception e) {
            System.out.println(e);
        }finally {
            threadPoolExecutor.shutdown();
        }
    }
}
class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        // 返回执行当前 Callable 的线程名字
        return Thread.currentThread().getName();
    }
}
