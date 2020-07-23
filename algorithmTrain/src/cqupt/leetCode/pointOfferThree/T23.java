package cqupt.leetCode.pointOfferThree;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yiLi
 * @create 2020-07-23 18:23
 * 合并k个有序链表
 */
public class T23 {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        if (lists == null || lists.length == 0) {
            return dummy.next;
        }
        ListNode cur = dummy;
        ComHelper23 com = new ComHelper23();
        PriorityQueue<ListNode> queue = new PriorityQueue<>(com);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null)// 此处要特判
                queue.offer(lists[i]);// 放进去各个链表的头
        }
        while (!queue.isEmpty()) {
            ListNode curNode = queue.poll();
            cur.next = curNode;
            cur = cur.next;
            if (curNode.next != null)
                queue.offer(curNode.next);
        }
        return dummy.next;
    }
}
class ComHelper23 implements Comparator<ListNode> {

    @Override
    public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
    }
}
