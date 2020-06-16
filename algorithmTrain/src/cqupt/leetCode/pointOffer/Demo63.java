package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-15 9:31
 */
public class Demo63 {

    public int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int[] dp = new int[prices.length];
        // 要记录n位置之前个n-1位置中最小的价格
        int minPrice = prices[0];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {// 2 --N
            if (prices[i] < minPrice) minPrice = prices[i];
            else dp[i] = dp[i - 1];
            if (prices[i] >= minPrice)
                dp[i] = Math.max((prices[i] - minPrice), dp[i - 1]);
            else dp[i] = dp[i - 1];
        }
        return dp[prices.length - 1];
    }

    public int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }
        return profit;
    }
    // 通用模板
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
 }