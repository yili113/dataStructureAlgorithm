package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-04 11:12
 * 两数相除，不能用除法、乘法、取模
 *
 * 用位运算
 */
public class T29 {
    public static void main(String[] args) {
        System.out.println(3<<3);
    }

    /**
     *
     * @param dividend 被除数
     * @param divisor 除数
     * @return
     */
    public int divide(int dividend, int divisor) {
        // 考虑除数为0的情况
        if (divisor == 0)
            return Integer.MAX_VALUE;
        // 考虑被除数是最小的数
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1)
                return Integer.MAX_VALUE;
            else if (divisor == 1)
                return Integer.MIN_VALUE;
        }
        long divd = (long) dividend;
        long divs = (long) divisor;
        // 考虑结果的符号问题
        int sign = 1;// 表示最终商的符号
        if (divd < 0) {
            divd = -divd;
            sign = -sign;
        }
        if (divs < 0) {
            divs = -divs;
            sign = -sign;
        }
        int res = 0;
        while (divd >= divs) {
            int shift = 0;
            while (divd >= divs << shift)
                shift ++;
            // res保存商
            res += 1 << (shift - 1);// 比如说当divs左移4位时候 divd < divs   就要取shift=3时候值
            divd -= divs << (shift - 1);// 在一次循环后要改变divd的值 32/3 一次循环后8/3
        }
        return res * sign;
    }
}
