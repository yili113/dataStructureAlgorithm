package cqupt.leetCode.pointOffer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-06-02 14:47
 */
public class Demo41_impor {
/*    // 时间复杂度太高
    private List<Integer> list;
    public Demo41() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
    }

    public double findMedian() {
        double res = 0;
        list.sort(new Com());
        int size = list.size();
        if (size % 2 == 1) {
            res = list.get(size / 2);
        }else {
            res = (list.get(size / 2) + list.get(size / 2 - 1)) / 2;
        }
        return res;
    }*/
    // 堆的插入和弹出都是O(N)
    // A 小顶堆  保存较大的那一半元素  奇数个数的话,A比B多一个元素
    // B 大顶堆  保存较小的那一半元素
    private Queue<Integer> A;
    private Queue<Integer> B;
    public Demo41_impor() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((x, y) -> (y - x));// 对于普通元素,大顶堆的创建
    }
    public void addNum(int num) {
        int m = A.size();
        int n = B.size();
        if (m == n) {
            B.offer(num);
            A.offer(B.poll());
        }else {
            A.offer(num);
            B.offer(A.poll());
        }
    }
    public double findMedian() {
        int m = A.size();
        int n = B.size();
        if (m == n) {
            return (A.peek() + B .peek())/ 2.0;
        }else {
            return A.peek();
        }
    }
}
class Com implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1 - o2;
    }
}
