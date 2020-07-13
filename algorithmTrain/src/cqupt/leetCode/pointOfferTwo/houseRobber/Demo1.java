package cqupt.leetCode.pointOfferTwo.houseRobber;

/**
 * @author yiLi
 * @create 2020-07-12 20:48
 */
public class Demo1 {
    // 输入：[1,2,3,1]
    // 输出：4
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        dp[1] = Math.max(nums[0], nums[1]);
//        for (int i = 2; i < dp.length; i++) {
//           dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);// 两种情况的最大值：1.上一天获得的最大金额
//            // 2.当天的额度+两天前获得的最大额度
//        }
//        return dp[dp.length - 1];
        int cur = 0;
        int pre = 0;
        int preP = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            cur = Math.max(nums[i] + preP, pre);
            preP = pre;
            pre = cur;
        }
        return cur;
    }
}
