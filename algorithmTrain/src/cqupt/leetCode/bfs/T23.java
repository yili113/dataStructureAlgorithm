package cqupt.leetCode.bfs;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Liyi
 * @create 2020-03-04 9:17
 */
public class T23 {
    /**
     * 创建一个实现了按照listNode的val值比较大小的比较器的优先队列
     * 再往优先队列中放listNode时队列头部是小元素，队列尾部是大元素
     * 当队列大小不为空的时候，就一直poll出队列的头（是队列中val最小的）
     * 加入到新链表的next。
     * 判断poll出的队列头是否有next,有的话就把next加进队列继续
     * @param lists 多条链表集合
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);// dummy是新链表的最头部
        if (lists == null || lists.length == 0)
            return dummy.next;// 此时dummy.next为空
        ComHelper comHelper = new ComHelper();
        PriorityQueue priorityQueue = new PriorityQueue(comHelper);// 实现比较器的优先队列
        ListNode cur = dummy;// cur是新链表中要移动的
        // 先把各个链表放进去
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)
                priorityQueue.add(lists[i]);
            // 其实这时候是add的整条链表，因为一条链表就可以由头结点表示的
            // 以后做题的时候 每条链表都要有指向当前结点的指针 只要这个指针在链表就不会丢
            // 在拼接两条链表的时候  要把A的头结点拼接到B的b结点后面，直接可以是b.next = A
            // 因为A有个curA指向了A头结点的下一个结点 A链表剩下的结点就不会丢
        }
        // 放进去PQ里面的最上面是最小的
        while (priorityQueue.size() != 0){// 只要PQ不为空就可以一直poll出来
            ListNode pollNode = (ListNode) priorityQueue.poll();
            cur.next = pollNode;
            cur = cur.next;
            if (pollNode.next != null) {// 判断当前poll出去的node是否还有next，如果有就把next加进PQ
                priorityQueue.add(pollNode.next);
            }
        }
        return dummy.next;
    }
}

class ComHelper implements Comparator<ListNode> {
    /**
     * 优先队列如果实现这个比较器的话，在优先队列中放元素，
     * 会按照队列头部是小元素，队列尾部是大元素原则
     * @param o1
     * @param o2
     * @return
     */
    @Override
    public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
