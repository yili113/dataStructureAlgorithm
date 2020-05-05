package cqupt.interviewQ.single.test;

import cqupt.interviewQ.single.singleDemo.Singleton6;

import java.util.concurrent.*;

/**
 * @author Liyi
 * @create 2020-05-01 21:31
 */
public class SingletonTest6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 多线程情况下普通的懒汉式会有并发安全问题
        Callable<Singleton6> c = new Callable<Singleton6>() {

            @Override
            public Singleton6 call() throws Exception {
                return Singleton6.getInstance();
            }
        };

        ExecutorService es = Executors.newFixedThreadPool(2);
        Future<Singleton6> f1 = es.submit(c);
        Future<Singleton6> f2 = es.submit(c);

        Singleton6 s1 = f1.get();
        Singleton6 s2 = f2.get();

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        es.shutdown();
    }
}
