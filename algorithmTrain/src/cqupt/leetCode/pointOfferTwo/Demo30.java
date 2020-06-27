package cqupt.leetCode.pointOfferTwo;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-06-27 10:14
 * 包含min的栈
 */
public class Demo30 {
    private Stack<Integer> stack;
    private int minValue;
    public Demo30() {
        stack = new Stack();
        minValue = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= minValue){
            stack.push(minValue);
            minValue = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == minValue)
            minValue = stack.pop();
    }

    public int top() {
         return stack.peek();
    }

    public int min() {
        return minValue;
    }
}
