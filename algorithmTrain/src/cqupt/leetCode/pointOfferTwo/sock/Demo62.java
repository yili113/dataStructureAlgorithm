package cqupt.leetCode.pointOfferTwo.sock;

/**
 * @author yiLi
 * @create 2020-07-08 9:02
 */
public class Demo62 {
    // 股票最大利润,买卖一次
    // 股票问题限制交易次数的时候,要注意在买的时候将次数-1,不要在卖的时候将次数-1
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[][] dp = new int[prices.length][2];
        dp[0][1] = -prices[0];
        dp[0][0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);// 第i天买了股票
            dp[i][0] = Math.max(dp[i - 1][0], prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
