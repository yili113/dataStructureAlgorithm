package cqupt.leetCode.monotonousStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-06-17 16:25
 * 下一个更大的元素  不是循环数组
 */
public class Demo {
    public static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();// 小元素剔除
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElements(new int[]{2,1,2,4,3})));
    }
}
