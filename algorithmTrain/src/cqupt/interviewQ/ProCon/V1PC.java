package cqupt.interviewQ.ProCon;

/**
 * @author yiLi
 * @create 2020-07-07 10:38
 * 利用sync实现生产者消费者模式
 */
public class V1PC {
    public static void main(String[] args) {
        V1Data data = new V1Data();
        new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t1").start();
        new Thread(() -> {
            for (int i = 0; i < 4; i++) {
                try {
                    data.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t2").start();
    }
}
class V1Data {
    private int number;

    public synchronized void increment() throws InterruptedException {
        while (number != 0)
            this.wait();
        number ++;
        System.out.println(Thread.currentThread().getName() + "生产了" + number);
        this.notify();
    }
    public synchronized void decrement() throws InterruptedException {
        while (number == 0)
            this.wait();
        number --;
        System.out.println(Thread.currentThread().getName() + "消费了" + number);
        this.notify();
    }
}