package cqupt.interviewQ.single.test;

import cqupt.interviewQ.single.singleDemo.Singleton5;

import java.util.concurrent.*;

/**
 * @author Liyi
 * @create 2020-05-01 21:31
 */
public class SingletonTest5 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 多线程情况下普通的懒汉式会有并发安全问题
        Callable<Singleton5> c = new Callable<Singleton5>() {

            @Override
            public Singleton5 call() throws Exception {
                return Singleton5.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton5> f1 = es.submit(c);
        Future<Singleton5> f2 = es.submit(c);

        Singleton5 s1 = f1.get();
        Singleton5 s2 = f2.get();

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        es.shutdown();
    }
}
