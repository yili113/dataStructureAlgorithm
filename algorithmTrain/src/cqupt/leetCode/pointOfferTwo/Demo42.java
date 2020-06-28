package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-28 15:19
 */
public class Demo42 {
    // [-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        if (n == 1)
            return nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = nums[i] > (nums[i] + dp[i - 1]) ? nums[i] : (nums[i] + dp[i - 1]);
        }
        int max = Integer.MIN_VALUE;
        for (int num : dp)
            max = num > max ? num : max;
        return max;
    }
}
