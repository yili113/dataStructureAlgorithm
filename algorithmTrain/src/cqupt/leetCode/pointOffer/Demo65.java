package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-12 15:12
 * 不用加减乘除做加法
 */
public class Demo65 {
    // 傻逼！
    public static int add1(int a, int b) {
        int temp1 = a ^ b;
        int temp2 = (a & b) << 1;
        return temp1 + temp2;
    }


    public static int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }
}