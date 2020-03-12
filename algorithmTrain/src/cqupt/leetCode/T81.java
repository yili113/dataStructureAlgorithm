package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-11 15:33
 * 同33题
 */
public class T81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length ==0)
            return false;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] > nums[start]) {
                if (nums[mid] >= target && nums[start] <= target)
                    end = mid;
                else
                    start = mid;
            }else if (nums[mid] < nums[start]) {
                if (nums[mid] <= target && nums[end] >= target)
                    start = mid;
                else
                    end = mid;
            }else
                start++;
        }
        if (nums[start] == target || nums[end] == target)
            return true;
        return false;
    }
}
