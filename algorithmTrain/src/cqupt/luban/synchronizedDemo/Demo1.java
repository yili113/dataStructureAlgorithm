package cqupt.luban.synchronizedDemo;

/**
 * @author Liyi
 * @create 2020-03-22 21:42
 */
public class Demo1 {
    private static int count;
    private Object object = new Object();
    public void test() {
        synchronized (object) {
            count --;
            System.out.println(Thread.currentThread().getName() + count);
        }
    }
    public static void test2() {
        synchronized (Demo1.class) {
            count --;
        }
    }
}
