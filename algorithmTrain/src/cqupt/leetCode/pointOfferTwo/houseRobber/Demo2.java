package cqupt.leetCode.pointOfferTwo.houseRobber;

/**
 * @author yiLi
 * @create 2020-07-12 21:00
 */
public class Demo2 {
    // 相邻的不能抢 并且首尾相连
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(robberRange(nums, 0, nums.length - 1), robberRange(nums, 1, nums.length - 2));
    }

    private int robberRange(int[] nums, int start, int end) {
        int cur = 0;
        int pre = 0;
        int preP = 0;
        for (int i = start; i <= end; i++) {
            cur = Math.max(nums[i] + preP, pre);
            pre = cur;
            preP = pre;
        }
        return cur;
    }
}
