package cqupt.leetCode.pointOfferTwo.sort;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-29 10:41
 */
public class MergeSort {


    private static void divide(int[] nums, int l, int r) {
        if (l >= r)
            return;
        int mid = (r - l) / 2 + l;
        divide(nums,l,mid);
        divide(nums,mid + 1,r);
        merge(nums, l, mid, r);
    }

    private static void merge(int[] nums, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int left = l;
        int right = mid + 1;
        int index = 0;
        while (left <= mid && right <= r) {
            if (nums[left] <= nums[right])
                temp[index ++] = nums[left ++];
            else
                temp[index ++] = nums[right ++];
        }
        while (left <= mid)
            temp[index ++] = nums[left ++];
        while (right <= r)
            temp[index ++] = nums[right ++];
        for (int i = l; i <= r; i++) {
            nums[i] = temp[i - l];
        }
    }


    public static void main(String[] args) {
        int[] arr = {8, 7, 5, 2, 3, 1, 2};
        divide(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
