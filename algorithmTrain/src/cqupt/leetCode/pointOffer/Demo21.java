package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-31 10:52
 * 调整数组顺序使奇数位于偶数前面
 */
public class Demo21 {
    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            if (nums[l] % 2 == 1) {
                l ++;
                continue;
            }
            if (nums[r] % 2 == 0) {
                r --;
                continue;
            }
            // 出来之后l 指向偶数 r指向奇数  换位置
            swap(nums, l, r);
            l ++;
            r --;
        }
        return nums;
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
