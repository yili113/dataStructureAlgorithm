package cqupt.interviewQ.ProCon;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yiLi
 * @create 2020-07-06 22:16
 */
public class BlockingQueuePC {
    public static void main(String[] args) {
        BlockingShareData data = new BlockingShareData(new ArrayBlockingQueue<String>(10));
        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                data.increment();
//            }
            data.increment();
        }, "t1").start();
        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                data.decrement();
//            }
            data.decrement();
        }, "t2").start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        data.stop();
    }
}
class BlockingShareData {
    private boolean FLAG = false;
    private BlockingQueue<String> blockingQeque;
    private AtomicInteger number = new AtomicInteger();

    public BlockingShareData(BlockingQueue<String> blockingQeque) {
        this.blockingQeque = blockingQeque;
    }

    public void increment() {
        String data = null;
        boolean success = false;
        while (FLAG) {
            data = number.incrementAndGet() + "";
            try {
                success = blockingQeque.offer(data, 2, TimeUnit.SECONDS);
                if(success)
                    System.out.println(Thread.currentThread().getName() + "生产了" + data);
                else
                    System.out.println(Thread.currentThread().getName() + "生产失败");
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    public void decrement() {
        String data = null;
        while (FLAG) {
            try {
//                data = (String) blockingQeque.take();
                data = blockingQeque.poll(2,TimeUnit.SECONDS);
                if (data == null || data.equals("")) {
                    FLAG = false;
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "消费了" + data);
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void stop() {
        FLAG = false;
    }

}
