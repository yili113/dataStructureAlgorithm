package cqupt.leetCode.pointOfferThree;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-07-24 15:07
 * 栈的压入弹出序列
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 */
public class Demo31 {
    // 用栈模拟一下压入,判断最终能够实现
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null)
            return false;
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int value : pushed) {
            stack.push(value);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
