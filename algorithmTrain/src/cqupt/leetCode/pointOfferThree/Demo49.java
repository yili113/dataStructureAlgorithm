package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-31 14:41
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 输出第10个丑数
 */
public class Demo49 {
    public int nthUglyNumber(int n) {
        int an = 0;// 表示2的丑数的下标
        int bn = 0;// 以3为倍数的丑数的下标
        int cn = 0;// 以5为倍数的丑数的下标
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[an] * 2, dp[bn] * 3), dp[cn] * 5);
//            if (dp[i] == dp[an] * 2)
//                an ++;
//            else if (dp[i] == dp[bn] * 3)
//                bn ++;
//            else if (dp[i] == dp[cn] * 5)
//                cn ++;
            // 此时每种丑数组成都必须是if
            // 假如说6是丑数  3(2为倍数的下标)*2    2(3为倍数的下标)*3  这两种情况为覆盖
            // 导致在 dp[5] 和 dp[6]都是6
            if (dp[i] == dp[an] * 2)
                an ++;
            if (dp[i] == dp[bn] * 3)
                bn ++;
            if (dp[i] == dp[cn] * 5)
                cn ++;
        }
        return dp[n - 1];
    }
}
