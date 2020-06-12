package cqupt.leetCode.pointOffer;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-12 8:42
 * 扑克牌中的顺子
 */
public class Demo61 {
    public static boolean isStraight(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0)
                zeroCount++;
        }
        Arrays.sort(nums);
        for (int i = zeroCount + 1; i < nums.length; i++) {// i从最后一个0的后两位开始算
            zeroCount -= nums[i] - nums[i - 1] - 1;
            if (zeroCount < 0 || nums[i] == nums[i - 1])// 连续两个数 相同也是没法构成顺子
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStraight(new int[]{1,2,12,0,3}));
    }
}
