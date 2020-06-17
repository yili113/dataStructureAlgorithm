package cqupt.interviewQ.single.singleDemo;

/**
 * @author yiLi
 * @create 2020-06-16 20:52
 * 饿汉式
 */
public class Singleton1 {
    private static Singleton1 instance = new Singleton1();
    public static Singleton1 getInstance() {
        return instance;
    }
}
