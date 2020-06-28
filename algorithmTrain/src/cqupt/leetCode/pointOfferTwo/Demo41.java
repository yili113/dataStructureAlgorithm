package cqupt.leetCode.pointOfferTwo;

import java.util.*;

/**
 * @author yiLi
 * @create 2020-06-28 14:50
 */
public class Demo41 {
    public void addNum(int num) {
        int m = queue1.size();
        int n = queue2.size();
        if (m == n) {
            // 往小顶堆放,大数那部分多一个元素
            queue2.offer(num);
            queue1.offer(queue2.poll());
        }else {
            queue1.offer(num);
            queue2.offer(queue1.poll());
        }
    }

    public double findMedian() {
        int m = queue1.size();
        int n = queue2.size();
        if (m == n)
            return (double) (queue1.peek() + queue2.peek()) / 2.0;
        else
            return (double) queue1.peek() / 1.0;
    }

    public Demo41() {
        queue1 = new PriorityQueue<Integer>();// 顶部是小元素 存放大数那边元素
//        queue2 = new PriorityQueue<>((x, y) -> (y - x));// 顶部是大元素
        Com com = new Com();
        queue2 = new PriorityQueue<>(com);
    }
    Queue<Integer> queue1;
    Queue<Integer> queue2;
}
class Com implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

