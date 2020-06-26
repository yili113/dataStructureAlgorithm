package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-26 10:54
 */
public class Demo16 {
    public double myPow(double x, int n) {
        if (x == 1 || n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n < 0) {// 考虑负数情况
            return 1 / (myPow(x, -(n + 1)) * x);
        }
        int res = 1;
        while (n > 1) {
            if (n % 2 != 0)
                res *= x;
            n /= 2;
            x *= x;
        }
        return res * x;
    }
}
