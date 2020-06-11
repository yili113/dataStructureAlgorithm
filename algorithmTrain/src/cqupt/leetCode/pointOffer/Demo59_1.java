package cqupt.leetCode.pointOffer;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yiLi
 * @create 2020-06-10 15:17
 */
public class Demo59_1 {
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || k == 0)
            return new int[]{};
        int[] res = new int[nums.length - k + 1];
        int i = 0;
        int j = i + k;// 左闭右开
        while (j <= nums.length) {
            int[] temp = new int[k];
            for (int index = i; index < j; index++) {
                temp[index - i] = nums[index];
            }
            int tempMax = getMax(temp);
            res[i] = tempMax;
            i++;
            j++;
        }
        return res;
    }

    private int getMax(int[] temp) {
        int max = Integer.MIN_VALUE;
        for (int num : temp)
            max = num > max ? num : max;
        return max;
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0)
            return new int[]{};
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for (int j = 0, i = 1 - k; j < nums.length; i ++, j++) {
            if (i > 0 && deque.peekFirst() == nums[i - 1])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[j])
                deque.removeLast();
            deque.addLast(nums[j]);
            if (i >= 0)
                res[i] = deque.peekFirst();
        }
        return res;
    }
}