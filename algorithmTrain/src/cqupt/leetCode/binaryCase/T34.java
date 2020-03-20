package cqupt.leetCode.binaryCase;

import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-03-04 20:34
 * 在排序数组中查找元素的第一个位置和最后一个位置
 */
public class T34 {


    /**
     * 考虑使用两次二分法 一次找元素初始位置 一次找元素结束位置
     *
     * 关键在于当target = nums[mid]时怎么处理指针移动：当找元素起始索引时候就要移动right指针
     * 不断把right位置往左移 一直移到和left相邻 这时候判断left或right中元素是否等于target时要先判断left的
     * 因为是找起始索引
     * 找结束索引的话反之一样
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return new int[]{-1, -1};
        int startPoint = -1;
        int endPoint = -1;
        // 找元素的初始位置
        int left = 0;
        int right = nums.length  - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {// 找起始索引，当target = nums[mid]时要挪动right
                right = mid;
            }else
                left = mid;
        }
        if (target == nums[left])// 此处的if-else if 中的顺序不能反，要是找起始位置就要先判断left位置是否满足，后判断right位置
            startPoint = left;
        else if (target == nums[right])
            startPoint = right;
        if (startPoint == -1)
            return new int[]{-1, -1};

        // 找原始终止位置
        left = 0;
        right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target >= nums[mid]) {// 找结束索引，当target = nums[mid]时要挪动left
                left = mid;
            }else
                right = mid;
        }
        if (target == nums[right])// 要是找结束位置就要先判断right位置再判断left位置，弄反了结果会错
            endPoint = right;
        else if (target == nums[left]) {
            endPoint = left;
        }
        if (endPoint != -1)
            return new int[]{startPoint, endPoint};
        else return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = {2, 2};
        int target = 2;
        int[] range = searchRange(arr, target);
        System.out.println(Arrays.toString(range));
    }
}
