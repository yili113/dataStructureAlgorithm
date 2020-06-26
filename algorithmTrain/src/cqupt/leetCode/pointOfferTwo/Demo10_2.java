package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-24 14:34
 */
public class Demo10_2 {
    // 答案需要取模 1e9+7（1000000007）
    public int numWays1(int n) {
        if (n <= 0)
            return 1;
        if (n == 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    public int numWays2(int n) {
        if (n <= 1)
            return 1;
        if (n == 2)
            return 2;
        int a = 1;
        int b = 2;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }
}
