package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-20 20:10
 * 数值的整数次方
 * 输入: 2.10000, 3
 * 输出: 9.26100
 */
public class Demo16 {
    public double myPow(double x, int n) {
        if (x == 1 || n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n < 0)
            return 1 / (Math.pow(x, -(n + 1)) * x);
        double res = 1;
        while (n > 1) {
            if (n % 2 == 1)
                res *= x;
            n /= 2;
            x *= x;
        }
        return res * x;
    }
}
