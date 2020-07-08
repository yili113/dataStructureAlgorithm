package cqupt.leetCode.monotonousStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-07-07 10:28
 */
public class TestMStack {
    // 通过单调栈找下一个更大的元素
    public static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i])
                stack.pop();
            res[i] = stack.isEmpty() ? -1 : stack.peek();// 因为数组从后往前遍历,所以栈顶有值的话就是比当前元素大的值,
            // 并且是离当前元素最近的那个较大值
            stack.push(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,2,4,3};
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }
}
