package cqupt.leetCode.pointOfferThree.SingletonTest;

/**
 * @author yiLi
 * @create 2020-07-21 10:09
 * 饿汉式直接加载
 * 优点：代码简洁易读,安全性高
 * 缺点：没法控制instance实例的创建,假如说访问类中其他的静态变量,instance就会被初始化,此时并没有调用getInstance
 */
public class Singleton1 {
    private Singleton1() {
        System.out.println("饿汉式单例");
    }
    private static Singleton1 instance = new Singleton1();
    public Singleton1 getInstance() {
        return instance;
    }
}
