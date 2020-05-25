package cqupt.leetCode.practiceLinked;

/**
 * @author yiLi
 * @create 2020-05-25 8:42
 * 指定区间内链表翻转
 */
public class Demo4 {
    public ListNode reversePart(ListNode head, int from, int to) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fromNode = dummy.next;
        ListNode toNode = dummy.next;
        ListNode pre = dummy;// 让pre一直在formNode前面
        for (int i = 1; i < from; i++) {
            pre = fromNode;
            fromNode = fromNode.next;
        }
        for (int i = 1; i < to; i++) {
            toNode = toNode.next;
        }
        while (fromNode != toNode) {
            pre.next = toNode.next;
            fromNode.next = toNode.next;
            toNode.next = fromNode;
            fromNode = pre.next;
        }
        return dummy.next;
    }
}
