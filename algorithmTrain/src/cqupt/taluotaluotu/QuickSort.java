package cqupt.taluotaluotu;

import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-05-03 9:26
 * 快速排序
 * 不稳定的NlogN
 * 最坏情况，反向排序的，就是N^2
 * 最好情况 N
 * 不需要额外空间
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int l = start + 1;
        int r = end;
        int pivot = nums[start];// 记住这个pivot选的是值而不是下标,因为后续比较的是值
        while (l <= r) {// l<=r为的是让出循环时候r指向在l左边
            if (nums[l] < pivot) {
                l ++;
                continue;
            }
            if (nums[r] >= pivot) {
                r --;
                continue;
            }
            // 能到这一步就说明l指向的元素比pivot大于或等于,或者r指向的元素比pivot小
            // 交换l r指向的元素,保证l指向的比pivot小...
            swap(nums, l, r);
        }
        // 出循环说明当前的pivot左边比其小,右边比其大
        // 但是pivot还是开始的start指向的元素,本质上start还没移动
        // 大概是：6      1 2 3       8 9 7
        //        satrt  比pivot小   比pivot大
        //                   r指向的是3   l指向的是8
        swap(nums, start, r);
        // 此时在是真正的pivot左边比其小右边比其大
        quickSort(nums, start, r - 1);
        quickSort(nums, l, end);
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
