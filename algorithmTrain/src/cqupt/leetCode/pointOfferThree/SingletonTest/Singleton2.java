package cqupt.leetCode.pointOfferThree.SingletonTest;

/**
 * @author yiLi
 * @create 2020-07-21 10:12
 * 优点:安全  延迟加载
 * 缺点：加锁太重,并发性不好
 */
public class Singleton2 {

    private Singleton2() {
        System.out.println("加锁实现懒汉式");
    }

    private static Singleton2 instance = null;

    public synchronized Singleton2 getInstance() {
        if (instance == null)
            instance = new Singleton2();
        return instance;
    }
}
