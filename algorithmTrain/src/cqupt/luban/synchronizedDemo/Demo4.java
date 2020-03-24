package cqupt.luban.synchronizedDemo;

/**
 * @author Liyi
 * @create 2020-03-23 8:54
 */
public class Demo4 {
    /**
     * 出现异常要进行处理,不然同步方法会释放锁
     */
    private int count = 0;
    synchronized void test() {
        System.out.println(Thread.currentThread().getName() + "start---------------");
        while (true) {
            count ++;
            System.out.println(Thread.currentThread().getName() + "count:" + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count == 5) {
                int i = 5 / 0;// 出现异常地方
            }
        }
    }

    public static void main(String[] args) {
        Demo4 demo4 = new Demo4();
        Runnable r = () -> demo4.test();// lambda表达式创建线程
        new Thread(r, "t1").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(r, "t2").start();// t2线程能否执行
    }
}
