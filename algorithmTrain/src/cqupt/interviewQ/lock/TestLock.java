package cqupt.interviewQ.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yiLi
 * @create 2020-06-04 21:59
 */
public class TestLock implements Runnable{
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        TestLock t1 = new TestLock();
        Thread t2 = new Thread(t1);
        t2.start();
        Thread.sleep(2000);
        lock.lock();
        condition.signal();
        System.out.println("main");
        Thread.sleep(2000);
        lock.unlock();
    }

    @Override
    public void run() {
        try {
            lock.lock();
            condition.await();
            System.out.println("thread is going on");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
