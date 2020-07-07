package cqupt.leetCode.pointOfferTwo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yiLi
 * @create 2020-07-05 10:18
 * 队列的最大值
 * 另外创建一个单调队列max来存当前队列deque中现有元素的最大值
 */
public class Demo59_2_impor {


    // 输入:
    //["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
    //[[],[1],[2],[],[],[]]
    //输出: [null,null,null,2,1,2]
    public Demo59_2_impor() {
        deque = new LinkedList<>();
        max = new LinkedList<>();
    }
    Deque<Integer> deque;
    LinkedList<Integer> max;// 专门存最大值的双端队列   单调递减
    public int max_value() {
//        return max.isEmpty() ? -1 : max.peekFirst();// 注释掉的是一样的效果
        return max.isEmpty() ? -1 : max.getFirst();
    }

    public void push_back(int value) {
//        deque.addLast(value);
//        while (!max.isEmpty() && max.peekLast() < value) {
//            max.pollLast();
//        }
//        max.addLast(value);
        deque.add(value);
        while (!max.isEmpty() && max.getLast() < value)
            max.removeLast();
        max.add(value);
    }

    public int pop_front() {
//        if (max.peekFirst().equals(deque.peekFirst()))
//            max.pollFirst();
//        return deque.isEmpty() ? -1 : deque.poll();
        if (!max.isEmpty() && max.getFirst().equals(deque.peek()))// 此处要max不为空才行,不然poll会空指针
            max.pollFirst();
        return deque.isEmpty() ? -1 : deque.poll();
    }
}
