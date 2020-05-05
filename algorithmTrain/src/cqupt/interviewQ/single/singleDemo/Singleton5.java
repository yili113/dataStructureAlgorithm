package cqupt.interviewQ.single.singleDemo;

/**
 * @author Liyi
 * @create 2020-05-01 21:25
 *
 *
 * 懒汉式
 * --延迟创建这个实例对象
 * 1.构造器私有化
 * 2.用一个静态变量保存这个唯一实例
 * 3.提供一个静态方法，获取这个实例对象
 */
public class Singleton5 {
    private Singleton5() {
    }
    private static Singleton5 instance;
    public static Singleton5 getInstance() {
        if (instance == null) {// 二次判断提高性能
            synchronized (Singleton5.class) {// 通过synchronized关键字解决并发问题
                if (instance == null) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    instance = new Singleton5();
                }
            }
        }
        return instance;
    }
}
