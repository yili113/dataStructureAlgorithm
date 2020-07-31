package cqupt.leetCode.pointOfferThree;

import java.util.PriorityQueue;

/**
 * @author yiLi
 * @create 2020-07-27 8:36
 * 数据流中的中位数
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 */
public class Demo41 {
    // 两个堆实现
    private PriorityQueue<Integer> queue1;
    private PriorityQueue<Integer> queue2;

    public Demo41() {
        queue1 = new PriorityQueue<>();// 小顶堆   大元素
        queue2 = new PriorityQueue<>((x, y) -> y - x);// 大顶堆  小元素
        // 如果是奇数个数元素,其中一个堆多放一个元素
    }

    public void addNum(int num) {
        if (queue1.size() == queue2.size()) {
            // 大顶堆多放一个元素
            queue1.offer(num);
            queue2.offer(queue1.poll());
        }else if (queue2.size() > queue1.size()) {
            queue2.offer(num);
            queue1.offer(queue2.poll());// 这种情况也是要每个堆都放一下的,考虑大顶堆:3,2,1  小顶堆 4,5
            // 此时要放0就不能直接放小顶堆,还是先放入大顶堆,在把大顶堆的顶放进小顶堆
        }
    }

    public double findMedian() {
        if (queue1.size() == 0 && queue2.size() == 0)
            return 0;
        if (queue1.size() == queue2.size())
            return (queue1.peek() + queue2.peek()) / 2.0;
        return queue2.peek() / 1.0;
    }
}
