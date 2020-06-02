package cqupt.leetCode.pointOffer;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-06-01 10:23
 */
public class Demo30 {
    private Stack<Integer> stack;
    private int minValue = Integer.MAX_VALUE;
    public Demo30() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if (x <= minValue) {
            stack.push(minValue);
            minValue = x;
        }
        stack.push(x);
    }

    public void pop() {
        Integer cur = stack.pop();
        if (cur == minValue) {
            minValue = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minValue;
    }
}
