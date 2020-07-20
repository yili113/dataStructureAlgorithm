package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-20 19:45
 */
public class Demo14_1 {
    public int cuttingRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        // 每段都尽量剪成3 最后乘积会最大
        int res = n % 3;
        if (res == 0)
            return (int) Math.pow(3, n / 3);
        else if (res == 1)
            return (int) (Math.pow(3,n / 3 - 1) * 4);
        else if (res == 2)
            return (int) (Math.pow(3, n / 3) * 2);
        return -1;
    }
}
