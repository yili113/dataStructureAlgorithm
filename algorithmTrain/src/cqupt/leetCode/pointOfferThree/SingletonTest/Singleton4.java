package cqupt.leetCode.pointOfferThree.SingletonTest;

/**
 * @author yiLi
 * @create 2020-07-22 9:38
 * 枚举实现单例
 * 线程安全,代码简洁,可读性强,支持编译期检查
 * 在反序列化时不会破坏单例
 */
public enum  Singleton4 {
    INSTANCE;

    private String objName;

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public static void main(String[] args) {
        Singleton4 instance = Singleton4.INSTANCE;
        instance.setObjName("firstName");
        System.out.println(instance.getObjName());
        Singleton4 instance1 = Singleton4.INSTANCE;
        System.out.println(instance.name());// INSTANCE
        // 枚举实现单例,instance和instance1根本就是一个实例
        System.out.println(instance == instance1);// true
        System.out.println(instance.equals(instance1));// true
        instance1.setObjName("secondName");
        System.out.println(instance.getObjName());// 将instance1的name改了之后instance的name也跟着改了
        System.out.println(instance1.getObjName());

        // 反射获取实例
        Singleton4[] enumConstants = Singleton4.class.getEnumConstants();
        for (Singleton4 singleton4 : enumConstants) {
            System.out.println(singleton4.getObjName());
        }
    }
}
