package cqupt.leetCode.pointOfferTwo;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-06-27 10:38
 */
public class Demo31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index ++;
            }
        }
        return stack.isEmpty();
    }
}
