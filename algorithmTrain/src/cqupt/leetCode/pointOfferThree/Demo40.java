package cqupt.leetCode.pointOfferThree;

import java.util.PriorityQueue;

/**
 * @author yiLi
 * @create 2020-07-26 13:13
 * 最小的k个数
 */
public class Demo40 {
    public int[] getLeastNumbers1(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return new int[]{};
        // PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : arr)
            pq.offer(num);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return new int[]{};
        helper(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private void helper(int[] nums, int left, int right, int k) {
        if (left >= right)
            return;
        int l = left + 1;
        int r = right;
        int pivot = nums[left];
        while (l <= r) {
            if (nums[l] <= pivot) {
                l ++;
                continue;
            }
            if (nums[r] > pivot) {
                r --;
                continue;
            }
            swap(nums, l, r);
        }
        swap(nums, left, r);
        if (r - left + 1 == k)
            return;
        if (r - left + 1 > k)
            helper(nums, left, r, k);
        else if (r - left + 1 < k)
            helper(nums, l, right, k - (l - left));
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

}
