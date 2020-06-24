package cqupt.luban;

/**
 * @author Liyi
 * @create 2020-03-27 22:48
 */
public class Test1 {
    static int a;

    public static void main(String[] args) {
        int b = 2;
        System.out.println(a + b);
        ClassLoader classLoader = Test1.class.getClassLoader().getParent().getParent();
        System.out.println(classLoader);
    }

}
