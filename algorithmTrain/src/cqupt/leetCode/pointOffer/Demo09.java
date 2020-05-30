package cqupt.leetCode.pointOffer;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-05-29 16:14
 * 别人的思路：
 * 一个栈用于添加队尾操作
 * 另一个栈用于移除队头操作
 */
public class Demo09 {
    Stack stack1 = null;
    Stack stack2 = null;
    public Demo09() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()) {
            return (int) stack2.pop();
        }
        if (stack1.isEmpty())
            return -1;
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return (int) stack2.pop();
    }
}
