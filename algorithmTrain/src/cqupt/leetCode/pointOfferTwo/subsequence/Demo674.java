package cqupt.leetCode.pointOfferTwo.subsequence;

/**
 * @author yiLi
 * @create 2020-07-13 14:08
 * 最长连续递增子序列
 */
public class Demo674 {
    // 输入: [1,3,5,4,7]
    // 输出: 3
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1])
                dp[i] = dp[i - 1] + 1;
        }
        int max = 0;
        for (int num : dp)
            max = num > max ? num : max;
        return max;
    }
}
