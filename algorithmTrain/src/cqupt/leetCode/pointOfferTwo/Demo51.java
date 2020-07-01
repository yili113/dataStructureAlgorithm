package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-01 16:14
 * 数组中的逆序对
 */
public class Demo51 {
    private static int COUNT;

    public static int reversePairs(int[] nums) {
        COUNT = 0;
        divide(nums, 0, nums.length - 1);
        return COUNT;
    }

    private static void divide(int[] nums, int left, int right) {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        divide(nums, left, mid);
        divide(nums,mid + 1, right);
        merge(nums, left, mid, right);
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int l = left;
        int r = mid + 1;
        int index = 0;
        while (l <= mid && r <= right) {
            if (nums[l] <= nums[r]) {
                temp[index ++] = nums[l ++];
            }else {
                COUNT += (mid - l + 1);// 遇到nums[l]>nums[r],就说明l--mid中间的元素都是比nums[r]大
                temp[index ++] = nums[r ++];
            }
        }
        while (l <= mid)
            temp[index ++] = nums[l ++];
        while (r <= right)
            temp[index ++] = nums[r ++];
        for (int i = left; i <= right; i++) {
            nums[i] = temp[i - left];
        }
    }

    public static void main(String[] args) {
        int[] nums = {7,5,6,4};
        System.out.println(reversePairs(nums));
    }
}
