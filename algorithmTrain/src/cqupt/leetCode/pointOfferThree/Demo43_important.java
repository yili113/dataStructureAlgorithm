package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-27 9:14
 * 1-n整数中1出现的次数
 */
public class Demo43_important {
    public int countDigitOne(int n) {

        return helper(n);

    }

    private int helper(int n) {
        if (n <= 0)// 这里一定要是<=0
            return 0;
        // 计算最高位方法
        String str = String.valueOf(n);
        int high = str.charAt(0) - '0';
        // 2234的pow就是1000
        int pow = (int) Math.pow(10, str.length() - 1);
        int last = n - pow * high;
        if (high == 1)
            return helper(pow - 1) + last + 1  + helper(last);
        // 例如 1234   helper(pow-1)就是1-999中1的个数
        // last+1就是1000-1234中1为千位时1的个数
        // helper(last)就是1000-1234中除去最高位1时还剩的0-234中1的个数
        else
            return helper(pow - 1) * high + pow + helper(last);
    }
}
