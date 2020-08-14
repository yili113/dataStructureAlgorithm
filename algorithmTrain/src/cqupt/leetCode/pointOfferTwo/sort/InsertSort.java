package cqupt.leetCode.pointOfferTwo.sort;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-30 19:01
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {8, 7, 5, 2, 3, 1, 2};
        System.out.println(Arrays.toString(sort(arr)));
    }

    private static int[] sort(int[] nums) {
//        // 第一轮
//        // 把第一个位置的元素插入到前面的位置,初始要插入的位置就是前一位置
//        int insertVal = nums[1];
//        int insertIndex = 0;
//        while (insertIndex >= 0 && nums[insertIndex] > insertVal) {
//            nums[insertIndex + 1] = nums[insertIndex];
//            insertIndex --;
//        }
//        nums[insertIndex + 1] = insertVal;
//
//        // 第二轮
//        insertVal = nums[2];
//        insertIndex = 1;
//        while (insertIndex >= 0 && nums[insertIndex] > insertVal) {
//            nums[insertIndex + 1] = nums[insertIndex];
//            insertIndex --;
//        }
//        nums[insertIndex + 1] = insertVal;

        // 合并起
        int insertIndex = 0;
        int insertVal = 0;
        for (int i = 1; i < nums.length; i++) {
            insertVal = nums[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && nums[insertIndex] > insertVal) {
                nums[insertIndex + 1] = nums[insertIndex];
                insertIndex --;
            }
            if ((insertIndex + 1) != (i - 1))// 进行优化 // 此处应该是  insertIndex != (i-1)
                nums[insertIndex + 1] = insertVal;
//            nums[insertIndex + 1] = insertVal;
        }
        return nums;
    }
}
