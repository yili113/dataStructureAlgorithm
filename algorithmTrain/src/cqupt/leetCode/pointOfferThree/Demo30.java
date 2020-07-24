package cqupt.leetCode.pointOfferThree;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-07-24 14:54
 * 包含min函数的栈
 */
public class Demo30 {
    private Stack<Integer> STACK;
    private int MIN;

    public Demo30() {
        STACK = new Stack<>();
        MIN = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= MIN) {// 这里的<=很重要,如果没有=号在pop上面那个min时,会多pop出一个数
            STACK.push(MIN);
            MIN = x;
        }
        STACK.push(x);
    }

    public void pop() {
        if (STACK.pop() == MIN)
            MIN = STACK.pop();// 在pop之后要更新下min
    }

    public int top() {
        return STACK.peek();
    }

    public int min() {
        return MIN;
    }
}
