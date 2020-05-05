package cqupt.interviewQ.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Liyi
 * @create 2020-05-05 9:44
 * 手写一个自旋锁
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference = new AtomicReference<>();// 初始值为null
    public void mylock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " thread is coming");
        while (!atomicReference.compareAndSet(null, thread)) {// 当前线程拿不到锁时候才会在里面不断while

        }
    }
    public void myUnlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);// 原子引用置为空,也就是释放锁
        System.out.println(thread.getName() + " thread has gone");
    }

    public static void main(String[] args) {
        SpinLockDemo spinLockDemo = new SpinLockDemo();
        new Thread(() -> {
            spinLockDemo.mylock();// 当前线程拿到锁
            try {
                TimeUnit.SECONDS.sleep(3);// 占用锁一会
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();// 释放锁
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);// 为了让t1先拿到锁,不然t1和t2谁先拿到就不一定
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {// t2线程就会在while里面自旋,不断进行条件判断,直到t1释放锁
            spinLockDemo.mylock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDemo.myUnlock();
        }, "t2").start();
    }
}
