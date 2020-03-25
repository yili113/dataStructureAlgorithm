package cqupt.leetCode.noClassified;

/**
 * @author Liyi
 * @create 2020-03-07 9:22
 */
public class T50 {

    /**
     * 负数的最小值 没办法通过直接取负号变成正数的最大值
     * 负数的最小值的绝对值要比正数最大值大1
     * MIN_VALUE = 2^32         MAX_VALUE = 2^32 -1
     */
    public static double myPow(double x, int n) {// 二分法
        if (x == 1 || n == 0)
            return 1;
        if (n == 1)
            return x;
        // 1.判断负次方时候
        if (n < 0) {
//            return 1 / myPow(x, -n);// 此处这样写会java.lang.StackOverflowError
            return 1 / (x * myPow(x, -(n + 1)));// 避免n是MIN_VALUE的时候  -MIN_VALUE != MAX_VALUE
            // 所以对MIN_VALUE先+1再取负号  但是+1之后相当于正数的次幂多1   所以要除去一个x
        }
        // 2.判断正次方时候
        double res = 1;
        while (n > 1) {
            // 2.1 判断奇数次方
            if (n % 2 != 0) {
                res *= x;// 奇数次方时候变成偶数次方 结果先乘上x
            }
            // 2.2 偶数次方
            n /= 2;
            x *= x;
        }
        res = res * x;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(myPow(2, 4));// 2^4 --->  4^2 ---> 16^1
    }
}
