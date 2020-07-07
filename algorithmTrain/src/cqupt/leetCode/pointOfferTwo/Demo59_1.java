package cqupt.leetCode.pointOfferTwo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yiLi
 * @create 2020-07-05 9:25
 */
public class Demo59_1 {
    // 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
    // 输出: [3,3,5,5,6,7]
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int l = 0;
        int r = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (r < nums.length) {
            r++;
            while ((r - l) == k) {
                // 计算区间最大值
                // 此处复杂度太高了
                int curMax = getMax(nums, l, r);// 左闭右开
                list.add(curMax);
                l++;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private int getMax(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        for (int i = l; i < r; i++) {
            max = max > nums[i] ? max : nums[i];
        }
        return max;
    }

    // 单调队列实现
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int i = 0;
        int j = 0;
        // 通过for循环,将窗口的i,j边界值不断移动,实现每次窗口内的元素个数都是k
        for (i = 1 - k,j = 0; j < nums.length; i++,j++) {// i从1-k开始
            if (i > 0 && nums[i - 1] == deque.peekFirst())// i只要>0就表明窗口的元素个数是k
                // 如果队列中最大值已经不在窗口中了,就需要把队列最大值删除
                deque.pollFirst();
            // 添加元素,构成单调递减队列
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.pollLast();
            deque.addLast(nums[j]);
            if (i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }
}
// 单调队列 非递增
class MonQueue {
    Deque<Integer> deque;

    public MonQueue() {
        deque = new LinkedList<>();
    }
    public void push(int num) {
        while (!deque.isEmpty() && deque.peekLast() < num)
            deque.pollLast();
        deque.addLast(num);
    }
    public void poll(int num) {
        if (!deque.isEmpty() && deque.peekFirst() == num)
            deque.pollFirst();
    }
    public int getMax() {
        return deque.peekFirst();
    }
}
