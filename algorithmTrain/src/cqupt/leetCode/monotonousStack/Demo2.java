package cqupt.leetCode.monotonousStack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-06-17 16:32
 * 距离下一个更温暖的温度需要的天数
 */
public class Demo2 {
    public static int[] nextWarmTemp(int[] T) {
        if (T == null || T.length == 0)
            return new int[]{};
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[stack.peek()] <= T[i])
                stack.pop();
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        // [73, 74, 75, 71, 69, 72, 76, 73]，你返回 [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(nextWarmTemp(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
