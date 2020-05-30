package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-30 15:09
 * TODO
 */
public class Demo14_impor {

    public int cuttingRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int a = n / 3;// 商
        int b = n - 3 * a;// 余数
        if (b == 1)
            return (int) Math.pow(3, a - 1) * 4;
        else if (b == 2)
            return (int) (Math.pow(3, a) * 2);
        else
            return (int) Math.pow(3, a);
    }
}
