package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-08-14 10:26
 */
public class Singleton {



    private static Singleton instance;

    private Singleton() {
    }

    public Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }
}
