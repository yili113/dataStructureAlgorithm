package cqupt.interviewQ.single.singleDemo;

/**
 * @author yiLi
 * @create 2020-06-16 21:05
 * 避免使用双重检查机制
 */
public class Singleton7 {
    private static Singleton7 instance = null;
    public static synchronized Singleton7 getInstance() {
        if (instance == null)
            instance = new Singleton7();
        return instance;
    }
}
