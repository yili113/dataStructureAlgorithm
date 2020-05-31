package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-31 11:10
 * 翻转链表
 */
public class Demo24 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode newHead = new ListNode(0);
        ListNode cur = head;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }
}
