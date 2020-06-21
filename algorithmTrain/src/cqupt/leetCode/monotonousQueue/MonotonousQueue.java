package cqupt.leetCode.monotonousQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yiLi
 * @create 2020-06-17 10:57
 */
public class MonotonousQueue {
    private Deque<Integer> deque;
    public MonotonousQueue() {
        deque = new LinkedList<>();
    }

    public int getMax() {
        return deque.peekFirst();
    }
    public void push(int value) {
        while (!deque.isEmpty() && deque.peekLast() < value)
            deque.pollLast();
        deque.push(value);
    }
    public void poll(int value) {
        if (!deque.isEmpty() && deque.peekFirst() == value)
            deque.pollFirst();
    }
}
