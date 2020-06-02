package cqupt.leetCode.pointOffer;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-02 11:06
 */
public class Demo40 {

    public static int[] getLeastNumbers1(int[] arr, int k) {
        int[] res = new int[k];
        if (arr == null || arr.length == 0)
            return res;
        Arrays.sort(arr);
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < arr.length; i++) {
//            while (set.size() < k) {
//                set.add(arr[i]);
//            }
//        }
//        int index = 0;
//        for (Iterator iter = set.iterator(); iter.hasNext();) {
//            res[index ++] = (int) iter.next();
//        }
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return new int[]{};
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOfRange(arr, 0, k);
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int l = start + 1;
        int r = end;
        int pivot = arr[start];
        while (l <= r) {
            if (arr[l] < pivot) {
                l ++;
                continue;
            }
            if (arr[r] >= pivot) {
                r --;
                continue;
            }
            swap(arr, l, r);
        }
        swap(arr, start, r);
        quickSort(arr, start, r - 1);
        quickSort(arr, l, end);
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}