package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-02 9:10
 * 在排序数组中查找数字
 */
public class Demo53_1 {
    // 输入: nums = [5,7,7,8,8,10], target = 8
    // 输出: 2
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        int left = binarySearch(nums, 1, 0, nums.length - 1, 8);
        int right = binarySearch(nums, 0, 0, nums.length - 1, 8);
        if (left == -1 || right == -1)
            return 0;
        return right - left + 1;
    }

    private static int binarySearch(int[] nums, int flag, int left, int right, int target) {
        int l = left;
        int r = right;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                if (flag == 1)
                    r = mid - 1;
                else if (flag == 0)
                    l = mid + 1;
            }
            else if (nums[mid] > target)
                r = mid - 1;
            else if (nums[mid] < target)
                l = mid + 1;
        }
        if (flag == 1) {
            if (l >= nums.length || nums[l] != target)
                return -1;
            else
                return l;
        }else {
            if (r < 0 || nums[r] != target)
                return -1;
            else
                return r;
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int left = search(nums, target);
        System.out.println(left);
    }
}
