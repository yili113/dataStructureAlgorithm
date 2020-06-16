package cqupt.leetCode.pointOffer.sock;

/**
 * @author yiLi
 * @create 2020-06-15 10:44
 * 包含冷冻期 卖出股票之后隔一天才能再次买入
 */
public class Demo3 {
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] + prices[i]);// 隔一天才能再买入
        }
        return dp[n - 1][0];
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_0 = 0;
        int dp_1 = -prices[0];
        int pre_0 = 0;
        for (int i = 1; i < n; i++) {
            int temp = dp_0;
            dp_0 = Math.max(dp_0, dp_1 + prices[i]);
            dp_1 = Math.max(dp_1, pre_0 - prices[0]);
            pre_0 = temp;
    }
        return dp_0;
    }
}
