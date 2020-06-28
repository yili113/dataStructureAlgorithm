package cqupt.leetCode.pointOfferTwo;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-06-28 15:31
 */
public class Demo40 {

    public int[] quickSort(int[] arr) {
        helper(arr, 0, arr.length - 1);
        return arr;
    }

    private void helper(int[] arr, int start, int end) {
        if (start >= end)
            return;
        int pivot = arr[start];
        int l = start + 1;
        int r = end;
        while (l <= r) {
            if (arr[l] < pivot) {
                l ++;
                continue;
            }
            if (arr[r] > pivot) {
                r --;
                continue;
            }
            swap(arr, l, r);
        }
        swap(arr,start,r);
        helper(arr,start, r - 1);
        helper(arr,l,end);
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 5, 2, 9};
        System.out.println(Arrays.toString(new Demo40().getLeastNumbers(arr,3)));
    }
    public int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>((x ,y) -> (y - x));// 大顶堆
        for (int num : arr) {
            if (queue.isEmpty() || queue.size() <= k || num < queue.peek()) {
                queue.offer(num);
            }
            if (queue.size() > k) {
                queue.poll();
            }
        }
        int[] res = new int[queue.size()];
        int index = res.length - 1;
        while (!queue.isEmpty()) {
            res[index --] = queue.poll();
        }
        return res;
    }
}
