package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-31 9:41
 */
public class Demo16 {
    // todo
    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        if (n == Integer.MIN_VALUE)
            return 0;
        int flag = n < 0 ? 0 : 1;// 如果n为负数 那flag就是0
        n = Math.abs(n);
        double res = 1;
        while (n > 1) {
            if (n % 2 == 1)
                res *= x;
            n /= 2;
            x *= x;
        }
        res *= x;
        return flag == 0 ? (1 / res) : res;
    }
}
