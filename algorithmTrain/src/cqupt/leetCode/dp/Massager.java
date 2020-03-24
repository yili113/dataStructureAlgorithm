package cqupt.leetCode.dp;

/**
 * @author Liyi
 * @create 2020-03-24 20:42
 * 按摩师---动态规划
 * 在第n个位置上的最优分成两种情况:1.选,就是n位置加n-2位置上的最优;2.不选,就是n-1位置上的最优
 */
public class Massager {
    public static int massage(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums = {2,1,4,5,3,1,1,3};
        System.out.println(massage(nums));
    }
}
