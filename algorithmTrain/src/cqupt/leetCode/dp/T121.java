package cqupt.leetCode.dp;

/**
 * @author Liyi
 * @create 2020-03-24 22:00
 * 遍历到n的时候,要记录前n-1个最小值作为买入价格
 * n位置的最大利润:如果n位置价格比之间n-1个价格中最小的大,就可以计算n位置的利润,再与n-1位置的最大利润比较,判断n位置的最大利润
 * 是取n-1位置的最大利润还是取n位置的当前利润
 */
public class T121 {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int n = prices.length;
        int minPrice = prices[0];// 对于当前第n个价格来说,minPrice为前n-1个价格中最小值
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {// i为dp的第i个元素,对应prices的i-1的价格
            if (prices[i - 2] < minPrice)
                minPrice = prices[i - 2];
            if (prices[i - 1] >= minPrice) {
                dp[i] = Math.max(prices[i - 1] - minPrice, dp[i - 1]);
            }else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
}
