package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-29 8:51
 * 1--n 整数中1出现的次数
 */
public class Demo43 {
    public int countDigitOne(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n < 0)
            return 0;
        String str = String.valueOf(n);
        int high = str.charAt(0) - '0';
        int pow = (int) Math.pow(10, str.length() - 1);
        int last = n - high * pow;
        if (high == 1)
            return helper(pow - 1) + helper(last) + last + 1;
        else
            return pow + high * helper(pow - 1) + helper(last);
    }
    // 3234这个数可以拆分成 1-999  1000-1999  2000-2999 3000-3234
    // 1-999部分是helper(pow-1)
    // 1000-1999部分可拆成两部分看  1.最高位是1的 一共是pow个  2.最高位不是1的就是helper(pow-1)
    // 2000-2999部分是helper(pow-1)
    // 3000-3234部分就是 helper(last)   last=234
}
