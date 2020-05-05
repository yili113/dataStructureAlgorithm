package cqupt.interviewQ.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Liyi
 * @create 2020-05-04 9:00
 */
public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        boolean b = atomicInteger.compareAndSet(5, 2019);
        atomicInteger.getAndAdd(1);
        System.out.println(atomicInteger.get());

    }
}

class User {
    int id;
    String name;
}