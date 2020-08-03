package cqupt.leetCode.pointOfferThree;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-08-03 9:46
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {9, 10, 4, 5, 77};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int pivot = arr[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (arr[l] <= pivot) {
                l ++;
                continue;
            }
            if (arr[r] > pivot) {
                r --;
                continue;
            }
            swap(arr, l, r);
        }
        swap(arr, left, r);
        quickSort(arr, left, r - 1);
        quickSort(arr, l, right);
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
