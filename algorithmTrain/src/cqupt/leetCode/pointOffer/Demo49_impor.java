package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-04 9:00
 */
public class Demo49_impor {
    public int nthUglyNumber(int n) {
        if (n < 0)
            return -1;
        // 建立三个队列分别存放 某一个丑数 * 2    *3   *5的值
        // 1*2  1*3  1*5  形成三个丑数   因为1本身就是丑数
        int a = 0;// *2  序列的下标
        int b = 0;// *3  序列的下标
        int c = 0;// *5  序列的下标
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int an = dp[a] * 2;
            int bn = dp[b] * 3;
            int cn = dp[c] * 5;
            dp[i] = Math.min(Math.min(an, bn), cn);
            if (dp[i] == an)
                a ++;
            if (dp[i] == bn)
                b ++;
            if (dp[i] == cn)
                c ++;
        }
        return dp[n - 1];
    }

}
