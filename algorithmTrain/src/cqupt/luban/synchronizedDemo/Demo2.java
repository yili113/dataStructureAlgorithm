package cqupt.luban.synchronizedDemo;

/**
 * @author Liyi
 * @create 2020-03-22 21:58
 */
public class Demo2 implements Runnable{
    private int count = 10;
    @Override
    public synchronized void run() {
        count --;
        // 在count--和打印之间会有并发安全问题
        System.out.println(Thread.currentThread().getName() + "count" + count);
        // output--->thread0count8,thread2count7,thread1count8,thread3count6,thread4count5
    }
    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();// 创建一个堆中共享的实例 不同线程共享count属性
        for (int i = 0; i < 5; i++) {
            new Thread(demo2, "thread" + i).start();// 启动五个线程
        }
    }
}
