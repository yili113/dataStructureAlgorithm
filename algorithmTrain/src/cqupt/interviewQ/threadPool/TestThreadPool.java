package cqupt.interviewQ.threadPool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yiLi
 * @create 2020-06-09 21:03
 */
public class TestThreadPool {
    public static void main(String[] args) {

        ThreadPoolExecutor pools = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS,
                new SynchronousQueue<>());
        for (int i = 0; i < 5; i++) {
//            pools.submit(new DivTask(100, i));// 利用submit将任务提交到线程池执行,不会报异常
            pools.execute(new DivTask(100, i));// 利用execute可以打印异常信息,部分堆栈信息
        }
    }
}
