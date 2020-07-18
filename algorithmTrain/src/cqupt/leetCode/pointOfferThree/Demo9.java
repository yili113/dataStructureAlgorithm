package cqupt.leetCode.pointOfferThree;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-07-18 12:55
 * 用两个栈实现队列
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 */
public class Demo9 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Demo9() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // 添加元素：
    // 直接往一个栈中加即可
    public void appendTail(int value) {
        stack2.push(value);
    }

    // 删除元素
    public int deleteHead() {
        if (!stack1.isEmpty())
            return stack1.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        if (!stack1.isEmpty()) {
            return stack1.pop();
        }else
            return -1;
    }
}
