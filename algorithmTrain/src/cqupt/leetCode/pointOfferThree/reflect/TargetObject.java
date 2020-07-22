package cqupt.leetCode.pointOfferThree.reflect;

/**
 * @author yiLi
 * @create 2020-07-22 14:52
 */
public class TargetObject {
    private String value;

    public TargetObject() {
        value = "yili";
    }

    public void publicMethod(String s) {
        System.out.println("i " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }
}
