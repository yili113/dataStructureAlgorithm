package cqupt.leetCode.pointOffer.sock;

/**
 * @author yiLi
 * @create 2020-06-16 8:44
 * 最多可以完成2笔交易   最多2笔！  最多
 */
public class Demo5 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n][k + 1][2];
        dp[0][1][0] = 0;
        dp[0][2][0] = 0;
        dp[0][1][1] = -prices[0];
        dp[0][2][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);// 交易次数要随着减少
                // 买入或者卖出的时候有一次减少交易次数就可以了
            }
        }
        return dp[n - 1][2][0];
    }
}
