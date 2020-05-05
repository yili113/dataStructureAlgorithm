package cqupt.interviewQ.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Liyi
 * @create 2020-05-05 21:13
 */
public class ConditionLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    shareResource.print5();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    shareResource.print10();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    shareResource.print15();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t3").start();
    }
}
class ShareResource {
    private int number = 1;
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    public void print5() throws InterruptedException {
        lock.lock();
        try {
            // 1.判断
            while (number != 1) {
                c1.await();
            }
            // 2.干活
            for (int i = 1; i <= 5 ; i++) {
                System.out.println(Thread.currentThread().getName() + "线程打印1的第" + i + "次");
            }
            // 3.通知
            number = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10() throws InterruptedException {
        lock.lock();
        try {
            // 1.判断
            while (number != 2) {
                c2.await();
            }
            // 2.干活
            for (int i = 1; i <= 10 ; i++) {
                System.out.println(Thread.currentThread().getName() + "线程打印2的第" + i + "次");
            }
            // 3.通知
            number = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print15() throws InterruptedException {
        lock.lock();
        try {
            // 1.判断
            while (number != 3) {
                c3.await();
            }
            // 2.干活
            for (int i = 1; i <= 15 ; i++) {
                System.out.println(Thread.currentThread().getName() + "线程打印3的第" + i + "次");
            }
            // 3.通知
            number = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
