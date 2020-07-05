package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-04 15:29
 * n个骰子的点数
 */
public class Demo60 {
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6 * n; j++) {// i个骰子一共能得到的点数
                for (int k = 1; k <= Math.min(6, j); k++) {// 第i个骰子可以贡献的点数
                    dp[i][j] += dp[i - 1][j - k];
                }
            }
        }
        int totalCount = 0;
        for (int num : dp[n])
            totalCount += num;
        double[] res = new double[6 * n - (n - 1)];
        for (int i = 0; i < res.length; i++) {
            res[i] = (double) dp[n][n + i] / totalCount;
        }
        return res;
    }
}
