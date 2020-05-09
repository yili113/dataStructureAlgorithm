package cqupt.interviewQ.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Liyi
 * @create 2020-05-06 8:48
 */
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // FutureTask这个类是实现了Runnable接口的,构造方法里面又需要Callable接口实现类
        FutureTask futureTask = new FutureTask<Integer>(new MyCallable());
        Thread t1 = new Thread(futureTask, "t1");
        Thread t2 = new Thread(futureTask, "t2");// 这个t2线程根本不会起作用，因为它跟t1线程做的任务一样，得到结果也是一样的
        t1.start();
        t2.start();
        System.out.println(futureTask.get());// output:1024


    }
}
class MyCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println("callable 接口实现类被调用了");
        return 1024;
    }
}
