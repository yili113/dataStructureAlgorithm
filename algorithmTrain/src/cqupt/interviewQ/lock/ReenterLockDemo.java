package cqupt.interviewQ.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Liyi
 * @create 2020-05-04 22:33
 * 可重入锁(递归锁)测试
 * 有了房间大门的钥匙,就能进卫生间、厕所等内部房间
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(() -> {
            phone.sendSMS();
        }, "t1").start();
        new Thread(() -> {
            phone.sendSMS();
        }, "t2").start();


        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t3 = new Thread(phone, "t3");
        Thread t4 = new Thread(phone, "t4");
        t3.start();
        t4.start();
    }
}
class Phone implements Runnable{
    public synchronized void sendSMS() {
        System.out.println(Thread.currentThread().getName() + "发送短信了");
        sendEmail();
    }
    private synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getName() + "发送邮件了");
    }
    @Override
    public void run() {
        get();
    }
    ReentrantLock lock = new ReentrantLock();
    private void get() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "线程的get方法启动了");
            set();
        }finally {
            lock.unlock();
        }
    }
    private void set() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "线程的set方法启动了");
        }finally {
            lock.unlock();
        }
    }
}
