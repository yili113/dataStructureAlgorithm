package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-02 16:23
 */
public class Demo43 {
    // 超过时间限制
    public int countDigitOne1(int n) {
        if (n <= 0)
            return 0;
        int res = 0;
        for (int i = 1; i <= n; i++) {
            char[] curChars = String.valueOf(i).toCharArray();
            for(char ch : curChars) {
                if (ch == '1')
                    res ++;
            }
        }
        return res;
    }

    public int countDigitOne(int n) {
        return helper(n);
    }

    private int helper(int n) {
        if (n <= 0)
            return 0;
        String str = String.valueOf(n);
        int high = str.charAt(0) - '0';
        int pow = (int) Math.pow(10,  (str.length() - 1));
        int last = n - pow * high;
        if (high == 1) {
            return last + 1 + helper(last) + helper(pow - 1);
        }else {
            return pow + high * helper(pow - 1) + helper(last);
        }
    }
}
