package cqupt.leetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-03-02 22:01
 * 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 */
public class T16 {
    /**
     *  暴力：资源消耗太大
     * @param nums 初始数组
     * @param target 目标值
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        ArrayList<Integer> list = new ArrayList<>();
        int len = nums.length;
//        Arrays.sort(nums);
        int gap = Integer.MAX_VALUE;// 定义初始的三数和与目标值的差值
        int base = 0;
        while (base < len - 2) {
            int baseVal = nums[base];
            for (int left = base + 1; left < len - 1; left++) {
                for (int right = left + 1; right < len; right++) {
                    int sum = baseVal + nums[left] + nums[right];
//                    gap = Math.min(Math.abs(sum - target), gap);
                    if (Math.abs(sum - target) <= gap) {
                        gap = Math.abs(sum - target);
                        list.add(sum);
                    }
//                    list.add(sum);
                }
            }
            base ++;
        }
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
//        System.out.println(threeSumClosest(nums, target));
        System.out.println(threeSumClosest1(nums, target));
    }

    /**
     * 效率高的办法 三指针
     * 开始没想到怎么写 left++和right--的条件
     * // newGap = nums[base] + nums[left] + nums[right] - target 就看这个差值
     * newGap < 0说明三数和需要增加，又因为数组排序了，所以left++,反之right--
     * @param nums
     * @param target
     * @return
     */
    private static int threeSumClosest1(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int gap = Integer.MAX_VALUE;
        for (int base = 0; base < len - 2; base++) {
            int left = base + 1;
            int right = len - 1;
            while (left < right) {
                int newGap = nums[base] + nums[left] + nums[right] - target;
                if (newGap == 0)
                    return target;// 差值为0直接返回target
                if (Math.abs(newGap) <= Math.abs(gap)) {
                    gap = newGap;
                }
                if (newGap < 0) {
                    left ++;
                }else {
                    right --;
                }
            }
        }
        return gap + target;
    }
}
