package cqupt.luban.synchronizedDemo;

/**
 * @author Liyi
 * @create 2020-03-23 8:44
 */
public class Demo3 {
    synchronized void test1() {
        System.out.println("test1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        test2();
    }
    synchronized void test2() {
        System.out.println("test2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        demo3.test1();
    }
}
