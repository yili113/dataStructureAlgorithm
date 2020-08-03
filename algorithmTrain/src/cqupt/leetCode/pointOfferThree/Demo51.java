package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-31 14:56
 * 数组中的逆序对  前面比后面大
 * 输入: [7,5,6,4]
 * 输出: 5
 */
public class Demo51 {
    private int COUNT;
    public int reversePairs(int[] nums) {
        COUNT = 0;
        if (nums == null || nums.length == 0)
            return COUNT;
        divide(nums, 0, nums.length - 1);
        return COUNT;
    }

    private void divide(int[] nums, int left, int right) {
        if (left >= right)// 分治排序在分的时候一定要考虑越界问题
            return;
        int mid = left + (right - left) / 2;
        divide(nums, left, mid);
        divide(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        if (left >= right)
            return;
        int[] temp = new int[right - left + 1];
        int index = 0;
        int l = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r])
                temp[index ++] = nums[l ++];
            else if (nums[l] > nums[r]) {
                COUNT += (mid - l + 1);
                temp[index ++] = nums[r ++];
            }
        }
        while (l <= mid)
            temp[index ++] = nums[l ++];
        while (r <= right)
            temp[index ++] = nums[r ++];
        // temp数组归还到原数组
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }
}
