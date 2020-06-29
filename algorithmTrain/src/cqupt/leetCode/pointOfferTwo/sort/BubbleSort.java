package cqupt.leetCode.pointOfferTwo.sort;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-29 9:48
 */
public class BubbleSort {
    // int[] arr = {8, 7, 5, 2, 9};
    public static int[] sort(int[] nums) {
        int n = nums.length;
        int temp = 0;
//        for (int i = 0; i < n - 1; i++) {
//            if (nums[i] > nums[i + 1]) {
//                temp = nums[i];
//                nums[i] = nums[i + 1];
//                nums[i + 1] = temp;
//            }
//        }
//        // 第二轮
//        for (int i = 0; i < n - 2; i++) {
//            if (nums[i] > nums[i + 1]) {
//                temp = nums[i];
//                nums[i] = nums[i + 1];
//                nums[i + 1] = temp;
//            }
//        }

        boolean flag = false;
        int index = 0;
        // 一共有n-1轮
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - (i + 1); j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = true;
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (!flag)// 如果有一轮一次交换都没发生说明已经是有序的了,就不需要后面的轮了
                break;
            flag = false;
            System.out.println(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 5, 2, 3, 1, 2};
        System.out.println(Arrays.toString(sort(arr)));
    }
}
