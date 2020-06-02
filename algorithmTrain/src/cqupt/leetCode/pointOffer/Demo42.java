package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-02 15:33
 */
public class Demo42 {
    // nums = [-2,1,-3,4,-1,2,1,-5,4]
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = dp[i] > res ? dp[i] : res;
        }
        return res;
    }
}
