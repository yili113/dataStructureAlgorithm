package cqupt.leetCode.pointOffer.sock;

/**
 * @author yiLi
 * @create 2020-06-15 10:30
 */
public class Demo1 {
    // k==1时候 只允许交易一次
    // dp[i][1][0] = max(dp[i-1][1][0], dp[i-1][1][1] + prices[i])
    // dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])// 在买的时候进行了交易数-1
    // 所以这个地方为dp[i-1][0][0] - prices[i]  dp[i-1][0][0]对于这道题又是不可能的 因为k==1不可能存在交易次数为0次的情况

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            // 相当于这里省了一个关于 k 的循环     for(j=1;j>=1;j--)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);// 买的时候减少交易次数
        }
        return dp[n - 1][0];
    }
}
