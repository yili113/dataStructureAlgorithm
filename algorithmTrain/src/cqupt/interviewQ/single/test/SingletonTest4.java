package cqupt.interviewQ.single.test;

import cqupt.interviewQ.single.singleDemo.Singleton4;

import java.util.concurrent.*;

/**
 * @author Liyi
 * @create 2020-05-01 21:31
 */
public class SingletonTest4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 多线程情况下普通的懒汉式会有并发安全问题
        Callable<Singleton4> c = new Callable<Singleton4>() {

            @Override
            public Singleton4 call() throws Exception {
                return Singleton4.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton4> f1 = es.submit(c);
        Future<Singleton4> f2 = es.submit(c);

        Singleton4 s1 = f1.get();
        Singleton4 s2 = f2.get();

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        es.shutdown();
    }
}
