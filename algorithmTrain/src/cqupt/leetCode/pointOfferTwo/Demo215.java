package cqupt.leetCode.pointOfferTwo;

import java.util.PriorityQueue;

/**
 * @author yiLi
 * @create 2020-06-29 9:33
 */
public class Demo215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return -1;
        PriorityQueue<Integer> queue = new PriorityQueue<>();// 堆顶是小元素
        for (int num : nums) {
            if (queue.isEmpty() || queue.size() <= k || queue.peek() < num)
                queue.offer(num);
            if (queue.size() > k)
                queue.poll();
        }
        return queue.poll();
    }
}
