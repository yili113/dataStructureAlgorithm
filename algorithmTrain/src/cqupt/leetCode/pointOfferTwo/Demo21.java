package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-26 15:07
 */
public class Demo21 {
    // 所有奇数在数组前,偶数在数组后
    public int[] exchange1(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if ((nums[l] & 1) == 1) {
                l ++;
                continue;
            }
            if ((nums[r] & 1) != 1) {
                r --;
                continue;
            }
            // 现在l r指向的都不是对应的元素,需要调换
            swap(nums, l, r);
        }
        return nums;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
    // 双指针从一端开始走
    public int[] exchange2(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1)
                swap(nums, slow ++, fast);
            fast ++;
        }
        return nums;
    }
}
