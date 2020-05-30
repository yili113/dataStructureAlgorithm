package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-30 9:18
 * 青蛙跳台阶
 */
public class Demo10_2 {
    public int numWays(int n) {
        if (n < 1)
            return 0;
//        int[] dp = new int[n + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
        if (n == 1)
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
