package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-10 9:46
 */
public class Demo57_1 {
    // rubbish
    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target)
                    return new int[]{nums[i], nums[j]};
            }
        }
        return null;
    }
    // 对排序数组操作 二分移动简单
    public int[] twoSum(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int sum = nums[l] + nums[r];
            if (sum < target)
                l ++;
            else if (sum > target)
                r --;
            else
                return new int[]{nums[l], nums[r]};
        }
        return null;
    }
}
