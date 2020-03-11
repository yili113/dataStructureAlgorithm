package cqupt.luban;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Liyi
 * @create 2020-03-08 16:59
 * 测试HashMap为啥是线程不安全的
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMapThread hashMapThread1 = new HashMapThread();
        HashMapThread hashMapThread2 = new HashMapThread();
        HashMapThread hashMapThread3 = new HashMapThread();
        HashMapThread hashMapThread4 = new HashMapThread();
        HashMapThread hashMapThread5 = new HashMapThread();
        hashMapThread1.start();
        hashMapThread2.start();
        hashMapThread5.start();
        hashMapThread3.start();
        hashMapThread4.start();

    }


}
class HashMapThread extends Thread {
    private static AtomicInteger a = new AtomicInteger();
    private static Map<Integer, Integer> hashMap = new HashMap();

    @Override
    public void run() {
        while (a.get() < 10000) {
            hashMap.put(a.get(), a.get());
            a.incrementAndGet();
        }
    }
}
