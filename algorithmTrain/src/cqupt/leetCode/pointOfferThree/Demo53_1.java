package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-08-03 10:00
 * 在排序数组中查找数字--统计数字出现的次数
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */
public class Demo53_1 {
    public static int search(int[] nums, int target) {
//        int left = binarySearch(nums, target, 0);
        int right = binarySearch(nums, target, 1);
        int left = binarySearch(nums, target, 0);
        if (left == -1 || right == -1)
            return 0;
        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        System.out.println(search(arr, 8));
    }
    private static int binarySearch(int[] nums, int target, int flag) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                if (flag == 0)// 左边界
                    r = mid - 1;
                else if (flag == 1)// 右边界
                    l = mid + 1;
            }
            else if (nums[mid] > target)
                r = mid - 1;
            else if (nums[mid] < target)
                l = mid + 1;
        }
        if (flag == 0) {
            if (l >= nums.length || nums[l] != target)
                return -1;
            return l;
        }else if (flag == 1) {
            if (r < 0 || nums[r] != target)
                return -1;
            return r;
        }
        return -1;
    }
}
