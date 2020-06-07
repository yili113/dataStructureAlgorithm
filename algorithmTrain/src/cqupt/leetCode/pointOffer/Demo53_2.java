package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-05 9:47
 */
public class Demo53_2 {
    // O(N) 可以优化时间复杂度
    public int missingNumber1(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }
        return nums[nums.length - 1] + 1;
    }
    // 排序数组查找首先想到二分  O(logN)
    // mid左侧是一一对应的
    // mid右侧开始不对应的
    // 最终出循环后 l指向右侧的开头
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == mid)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }
}
