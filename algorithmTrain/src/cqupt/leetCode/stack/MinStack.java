package cqupt.leetCode.stack;

import java.util.Stack;

/**
 * @author Liyi
 * @create 2020-05-12 10:20
 */
public class MinStack {
    private Stack<Integer> minStack = null;
    private int minValue;

    public MinStack() {
        minStack = new Stack<>();
        minValue = Integer.MAX_VALUE;
    }

    /**
     * 始终保证新加入的元素是最小元素时，它下面有一个次小元素
     * 这个次小元素是copy的,新增到stack中的,多余的
     * @param x
     */
    public void push(int x) {
        if (x <= minValue) {
            minStack.push(minValue);
            minValue = x;
        }
        minStack.push(x);
    }

    /**
     * 如果minStack.pop() == minValue就会进行两次pop
     * 否则就是一次pop
     */
    public void pop() {
        // 首先minStack.pop()这个操作有就代表栈顶元素弹出了
        // 如果要弹出的栈顶元素是minValue的话,它紧挨下面的一个元素是多添加进去的第二小的元素
        // 也要移除,但是要保留第二小元素的值,
        // 就用到minValue = minStack.pop()拆分成两步，第一步将次小元素移除，第二步将次小元素的值赋给minValue
        if (minStack.pop() == minValue) {
            minValue = minStack.pop();
        }
    }

    public int top() {
        return minStack.peek();
    }

    public int getMin() {
        return minValue;
    }
}
