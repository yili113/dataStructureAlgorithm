package cqupt.interviewQ.blockQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Liyi
 * @create 2020-05-05 22:01
 */
public class BlockingQueueProCon {
    public static void main(String[] args) {
        MyResource resource = new MyResource(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "生产线程启动");
            try {
                resource.pro();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "pro thread").start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "消费线程启动");
            System.out.println();
            System.out.println();
            try {
                resource.cons();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "cons thread").start();
        // 先让生产消费线程跑一会
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        resource.stop();// 停止所有操作
    }
}
class MyResource {
    private volatile boolean FLAG = true;// 控制生产与消费的总开关
    private BlockingQueue<String> blockingQueue = null;// 用接口,不用具体实现类
    private AtomicInteger atomicInteger = new AtomicInteger();// 保证原子性,代替锁

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());// 看实现类用的是什么具体方法
        System.out.println();
    }

    // 生产方法
    public void pro() throws InterruptedException {
        String data = null;
        boolean result;
        while (FLAG) {// 只要flag为true就一直生产
            data = atomicInteger.incrementAndGet() + "";// 转成字符串
            result = blockingQueue.offer(data, 2, TimeUnit.SECONDS);// 添加数据,要是2秒还没成功就放弃掉
            if (result)
                System.out.println(Thread.currentThread().getName() + "线程添加数据" + data + "成功");
            else
                System.out.println(Thread.currentThread().getName() + "线程添加数据" + data + "失败");
            // 每次添加完休息一会
            TimeUnit.SECONDS.sleep(1);
        }
        // 如果flag=false就要停止生产了
        System.out.println(Thread.currentThread().getName() + "线程要停止生产了");
    }
    // 消费方法
    public void cons() throws InterruptedException {
        String result;
        while (FLAG) {// 只要为true就要一直消费
            result = blockingQueue.poll(2, TimeUnit.SECONDS);// 2秒拿不出数据就放弃
            if (result == null || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "线程超出时间拿不到数据了,消费退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "线程取出数据 " + result + " 成功");
        }
    }
    // 停止方法
    public void stop() {
        this.FLAG = false;
    }
}
