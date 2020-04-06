package cqupt.leetCode.noClassified;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Liyi
 * @create 2020-04-03 11:41
 * 数组中第k个最大元素
 */
public class T215 {
    public static int findKthLargest1(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    /**
     * 利用优先队列
     * 始终保持队列中只有两个元素，当元素个数大于2时就要把多余的remove掉
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return 0;
        PriorityQueue pq = new PriorityQueue<Integer>();
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if (pq.size() > k)
                pq.remove();
        }
        return (int) pq.peek();// 返回pq的头部元素(此时就是K者中最小的那个)
    }
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};
        int k = 2;
        System.out.println(findKthLargest(nums, k));
    }

    /**
     * 快速排序解法
     * @param nums
     * @param k
     * @return
     */
    private static int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    private static void quickSort(int[] nums, int left, int right) {
        int l = left;
        int r = right;
        int mid = nums[l + (r - l) / 2];
        while(l < r) {
            while (nums[l] < mid)// mid右边的都比mid大
                l += 1;
            while (nums[r] > mid)
                r -= 1;
            if (l >= r)
                break;
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            if (nums[l] == mid)
                r -= 1;
            if (nums[r] == mid)
                l += 1;
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        if (left < r)// 由于上述判断 出来之后 r在l左侧
            quickSort(nums, left , r);
        if (right > l)
            quickSort(nums, l, right);
    }
}
