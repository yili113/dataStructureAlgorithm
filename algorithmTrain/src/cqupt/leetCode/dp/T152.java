package cqupt.leetCode.dp;

/**
 * @author Liyi
 * @create 2020-04-06 10:23
 * 乘积最大子数组
 */
public class T152 {
    // 错误解法
    // 此方法没有考虑到  当前数为负  并且前面子数组乘积也为负的情况  这样乘出来就会是个很大的正数
    public static int maxProduct1(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1] * nums[i - 1], nums[i - 1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > max)
                max = dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        System.out.println(maxProduct(nums));
    }

    /**
     * 1.如果nums[i]>=0
     * 1.1 如果dp[i-1]>=0(i元素前面的最大子数组乘积),则dp[i]=dp[i-1]*nums[i] 需要记录之前子数组的最大值
     * 1.2 如果dp[i-1]<0,则dp[i]=nums[i]
     * 2.如果nums[i]<0
     * 2.1 如果dp[i-1]<0,则dp[i]=dp[i-1]*nums[i] 需要记录之前的子数组的最小值
     * 2.2 如果dp[i-1]>=0,则dp[i]=nums[i]
     * @param nums
     * @return
     */
    private static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        int[] minArr = new int[len];
        int[] maxArr = new int[len];
        minArr[0] = nums[0];
        maxArr[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < len; i++) {
            maxArr[i] = Math.max(nums[i], Math.max(minArr[i - 1] * nums[i], maxArr[i - 1] * nums[i]));
            minArr[i] = Math.min(nums[i], Math.min(maxArr[i - 1] * nums[i], minArr[i - 1] * nums[i]));
            max = Math.max(maxArr[i], max);
        }
        return max;
    }
}
