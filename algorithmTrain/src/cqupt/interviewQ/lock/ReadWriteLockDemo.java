package cqupt.interviewQ.lock;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Liyi
 * @create 2020-05-05 10:13
 * 实现读写锁
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCache cache = new MyCache();// 线程操作资源类
        // 多个线程写
        for (int i = 1; i < 3; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.put(temp +"", temp +"");
            }, String.valueOf(i)).start();
        }
        // 多个线程读
        for (int i = 1; i < 3; i++) {
            final int temp = i;
            new Thread(() -> {
                cache.get(temp +"");
            }, String.valueOf(i)).start();
        }
    }
}
class MyCache {
    private volatile HashMap<String, Object> map = new HashMap<>();// volatile保证线程间可见性
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    public void put(String key, Object value) {
        rwLock.writeLock().lock();// 加写锁

        try {
            System.out.println(Thread.currentThread().getName() + "线程正在写入：" + key);
            try {
                TimeUnit.MILLISECONDS.sleep(200);// 模拟网络延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "线程写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }

    }
    public void get(String key) {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + "线程正在读取");
            try {
                TimeUnit.MILLISECONDS.sleep(200);// 模拟网络延迟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程读取完成：" + map.get(key));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }

    }
}
