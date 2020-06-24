package cqupt.leetCode.pointOfferTwo;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-06-23 17:09
 */
// 输入：
//["CQueue","appendTail","deleteHead","deleteHead"]
//[[],[3],[],[]]
//输出：[null,null,3,-1]

// 两个栈实现队列
// 队列是先进先出,两个栈,肯定一个栈负责进元素(队尾添加元素) 一个栈负责出元素(队头出元素)
// 添加进栈的元素,再要实现队列头出,怎么办呢？那就将元素从一个栈转移到另一个栈,这样就实现了栈底元素变栈顶元素
public class Demo09 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public Demo09() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty())
            return stack2.pop();
        if (stack1.isEmpty())
            return -1;
        // 说明stack2中没有元素了,但是stack1中有,那就从stack1转移到stack2中
        // stack1中下面的元素是要作为队列头输出的
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
