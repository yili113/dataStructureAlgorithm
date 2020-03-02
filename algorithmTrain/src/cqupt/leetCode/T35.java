package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-02 11:38
  搜索插入位置：
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

你可以假设数组中无重复元素。
 */
public class T35 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
    }


    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length < 1)
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid;
            }else if (target < nums[mid]) {
                right = mid;
            }else {
                return mid;
            }
        }
        if (target <= nums[left]) {// 直接返回索引是这样返回的 <=left的话 该值就应该放在left位置
            return left;
        }else if (target > nums[right]) {
            return right + 1;
        }else {
            return right;
        }
    }
}
