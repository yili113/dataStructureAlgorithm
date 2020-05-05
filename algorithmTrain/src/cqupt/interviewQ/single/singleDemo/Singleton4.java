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
public class Singleton4 {
    private Singleton4() {
    }
    private static Singleton4 instance;// 此处属性得是私有的,因为对外提供的get方法,属性处没有new,如果是public的话,外部直接拿属性值可能为空
    public static Singleton4 getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(200);// 懒汉式这样会造成线程不安全问题
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new Singleton4();
        }
        return instance;
    }
}
