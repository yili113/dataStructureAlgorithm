package cqupt.taluotaluotu;

import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-05-03 10:22
 * 归并排序
 * 稳定的  NlogN
 * 需要另外开辟空间
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        mergeSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        for (int idx = 0; idx <= end - start; idx++) {
            if (i > mid) {// 左边的都已经排序完了,此时只需要把右侧剩下的按顺序加进去
                temp[idx] = nums[j];
                j ++;
                continue;
            }
            if (j > end) {// 右侧的都已经排序完了
                temp[idx] = nums[i];
                i ++;
                continue;
            }
            if (nums[i] < nums[j]) {
                temp[idx] = nums[i];
                i ++;
            }else {
                temp[idx] = nums[j];
                j ++;
            }
        }
        // 再把temp中元素拷贝回nums
        for (int idx = 0; idx <= end - start; idx++) {
            nums[start + idx] = temp[idx];
        }
    }
}
