package cqupt.leetCode.pointOffer;

import java.util.HashSet;

/**
 * @author yiLi
 * @create 2020-05-29 14:35
 */
public class Demo03 {
    // 自己使用 set做的   时间复杂度O(N)   空间复杂度  O(N)
    public int findRepeatNumber1(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            }else
                return nums[i];
        }
        return 0;
    }
    // 原地操作数组 空间复杂度O(1)
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1)
            return 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i) {
                i ++;
                continue;
            }
            if (nums[i] == nums[nums[i]])// 出现重复元素
                return nums[i];
            int temp = nums[i];// 不断将i位置上的元素换成i   nums[i]==i
            nums[i] = nums[temp];
            nums[temp] = temp;
        }
        return 0;
    }
}
