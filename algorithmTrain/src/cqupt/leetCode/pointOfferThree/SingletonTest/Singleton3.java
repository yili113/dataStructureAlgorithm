package cqupt.leetCode.pointOfferThree.SingletonTest;

/**
 * @author yiLi
 * @create 2020-07-21 10:14
 * 优点：延迟加载 无锁但是安全
 * 利用类加载的特点,外部类初始化时候内部类不初始化
 * 通过getInstance()方法来返回内部类的静态变量
 */
public class Singleton3 {
    private Singleton3() {
        System.out.println("内部类实现懒汉式");
    }

    private static class Inner {
        private static Singleton3 instance = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return Inner.instance;
    }
}
