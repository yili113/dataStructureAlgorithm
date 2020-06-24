package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-23 9:00
 */
public class Demo03 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int index = 0;
        while (index < nums.length) {
            if (index == nums[index]) {
                index ++;
                continue;
            }
            // 出现重复元素情况
            if (nums[index] == nums[nums[index]])
                return nums[index];
            int temp = nums[index];
            nums[index] = nums[temp];
            nums[temp] = temp;
        }
        return -1;
    }
}
