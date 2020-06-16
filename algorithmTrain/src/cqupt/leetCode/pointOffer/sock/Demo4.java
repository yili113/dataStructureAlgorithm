package cqupt.leetCode.pointOffer.sock;

/**
 * @author yiLi
 * @create 2020-06-16 8:36
 * 含手续费的买卖股票
 */
public class Demo4 {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];// fee表示交易股票的手续费,在卖出时候计算方便
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
