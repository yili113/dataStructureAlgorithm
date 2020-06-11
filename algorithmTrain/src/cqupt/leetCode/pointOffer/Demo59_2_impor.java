package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-11 8:43
 */
public class Demo59_2_impor {
    // 若队列为空 pop 和 getMax 都是返回 -1
//    private Queue queue = null;
//    private int MAX = Integer.MIN_VALUE;
    int[] queue;
    int queueHead = 0;
    int queueTail = 0;
    int[] maxQueue;
    int maxQueueHead = 0;
    int maxQueueTail = 0;
    public Demo59_2_impor() {
//        queue = new LinkedList();
        queue = new int[10000];
        maxQueue = new int[10000];
    }
    public int max_value() {
        if (maxQueueHead == maxQueueTail)
            return -1;
        return maxQueue[maxQueueHead];
    }

    public void push_back(int value) {
        queue[queueTail ++] = value;
        // 判断新加的value应该出在maxQueue的什么位置
        while (maxQueueHead != maxQueueTail && maxQueue[maxQueueTail - 1] < value)
            maxQueueTail --;
        maxQueue[maxQueueTail ++] = value;
    }

    public int pop_front() {
        if (queueHead == queueTail)
            return -1;
        int res = queue[queueHead];
        if (res == maxQueue[maxQueueHead]) {
            queueHead ++;
            maxQueueHead ++;
        }else
            queueHead ++;
        return res;
    }
}
