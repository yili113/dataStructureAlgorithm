package cqupt.leetCode.pointOfferTwo.subsequence;

/**
 * @author yiLi
 * @create 2020-07-13 14:16
 * 最长上升子序列
 */
public class Demo300 {
    // 输入: [10,9,2,5,3,7,101,18]
    // 输出: 4  ----  2,3,7,101

    // O(n^2)
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    dp[i] = dp[j] + 1 > dp[i] ? dp[j] + 1 : dp[i];
            }
        }
        int max = Integer.MIN_VALUE;
        for (int num : dp)
            max = max > num ? max : num;
        return max;
    }
}
