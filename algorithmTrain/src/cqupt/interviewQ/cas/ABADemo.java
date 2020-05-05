package cqupt.interviewQ.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Liyi
 * @create 2020-05-04 10:23
 */
public class ABADemo {


    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);
    public static void main(String[] args) {
//        new Thread(() -> {
//            atomicReference.compareAndSet(100, 101);
//            atomicReference.compareAndSet(101, 100);
//        }, "t1").start();
//        new Thread(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println(atomicReference.compareAndSet(100, 2019) + "\t" + atomicReference.get());
//        }, "t2").start();
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            try {
                TimeUnit.SECONDS.sleep(1);// 这里停1秒是为了让t4和t3拿到相同的初始时间戳
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 动态改变时间戳
            boolean b = atomicStampedReference.compareAndSet(100, 101, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName() + "修改成功与否：" + b);
//            atomicStampedReference.compareAndSet(101, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println(Thread.currentThread().getName()+"---"+atomicStampedReference.getStamp());
        }, "t3").start();
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            boolean b = atomicStampedReference.compareAndSet(100, 2019, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("b is :" + b);
            System.out.println("atomicStampedReference的当前值是：" + atomicStampedReference.getReference() + "当前stamp是：" + atomicStampedReference.getStamp());
            boolean b1 = atomicStampedReference.compareAndSet(2019, 100, atomicStampedReference.getStamp(), atomicStampedReference.getStamp() + 1);
            System.out.println("b1 is :" + b1);
            System.out.println(Thread.currentThread().getName()+"---"+atomicStampedReference.getStamp());
        }, "t4").start();
    }
}
