package cqupt.leetCode.pointOfferTwo;

import java.util.concurrent.TimeUnit;

/**
 * @author yiLi
 * @create 2020-08-14 10:22
 */
public class DeadLock {
    public static void main(String[] args) {
        String lockA = "AAA";
        String lockB = "BBB";
        new Thread(new DeadLockHold(lockA, lockB), "A线程").start();
        new Thread(new DeadLockHold(lockB, lockA), "B线程").start();

    }
}
class DeadLockHold implements Runnable{
    private String lockA;
    private String lockB;

    public DeadLockHold(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "拿到锁" + lockA);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "拿到锁" + lockB);
            }
        }
    }
}
