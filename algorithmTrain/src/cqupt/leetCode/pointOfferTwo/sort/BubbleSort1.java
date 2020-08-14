package cqupt.leetCode.pointOfferTwo.sort;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-08-12 20:22
 */
public class BubbleSort1 {
    public static void main(String[] args) {
        int[] arr = {542, 3, 53, 214, 14, 22};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        // 第一轮 将第一大的数换到最后
//        for (int i = 1; i < n; i++) {
//            if (arr[i] < arr[i - 1])
//                swap(arr, i, i - 1);
//        }
        boolean flag = false;
        // 一共n-1轮 n个数
        for (int i = 0; i < n - 1; i++) {
            flag = false;
            for (int j = 1; j < n - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    flag = true;
                    swap(arr, j, j - 1);
                }
            }
            if (!flag)
                break;
        }
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
