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
        // 因为首尾不能同时选
        // 1.选首不选尾 2.选尾不选首
        return Math.max(robberRange(nums, 0, nums.length - 2), robberRange(nums, 1, nums.length - 1));
    }

    private int robberRange(int[] nums, int start, int end) {
        int cur = 0;
        int pre = 0;
        int preP = 0;
        for (int i = start; i <= end; i++) {
            cur = Math.max(nums[i] + preP, pre);
            preP = pre;// 这二者顺序不能反  不然pre会被覆盖
            pre = cur;
        }
        return cur;
    }
}
