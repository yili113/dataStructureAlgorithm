package cqupt.leetCode.noClassified;

/**
 * @author Liyi
 * @create 2020-03-02 14:00
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class T53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        /**
         * maxToCur 包含当前元素的最大子序和
         * max 整体的最大子序和
         * 都是从第一个元素开始 不能初始化0   避免数组中全是负数的情况
         */
        int maxToCur = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxToCur = Math.max(maxToCur + nums[i], nums[i]);// 判断上一个maxToCur是不是累赘，不是就留下，是的话就去掉
            max = Math.max(max, maxToCur);
        }
        return max;
    }
}
