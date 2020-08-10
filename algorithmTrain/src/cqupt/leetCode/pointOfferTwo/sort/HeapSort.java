package cqupt.leetCode.pointOfferTwo.sort;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-08-10 22:29
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {542, 3, 53, 214, 14, 748};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        int n = arr.length;
        // 1.做成大顶堆
        buildHeap(arr, n);
        // 2.不断交换首尾结点
        for (int i = n - 1; i > 0; i--) {// 交换第i个结点和第0个结点
            swap(arr, i, 0);
            heapify(arr, i, 0);// 共i个结点,每次减少一个结点
        }
    }

    // n个结点
    public static void buildHeap(int[] arr, int n) {
        int lastNode = n - 1;
        // 从最后一个非叶子结点开始向上调整,做heapify()
        int lastParent = (lastNode - 1) / 2;
        for (int i = lastParent; i >= 0; i--) {//
            heapify(arr, n, i);// todo 这里需要调整的结点可以不写成n
        }
    }

    // n个结点做heapify()  i结点为当前的父结点的下标
    public static void heapify(int[] arr, int n, int i) {
        if (i >= n)
            return;
        int max = i;
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        if (c1 < n && arr[c1] > arr[max])
            max = c1;
        if (c2 < n && arr[c2] > arr[max])
            max = c2;
        if (max != i) {// 说明当前父结点值被更换了
            swap(arr, i, max);
            heapify(arr, n, max);// 以max为父结点继续向下调整
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
