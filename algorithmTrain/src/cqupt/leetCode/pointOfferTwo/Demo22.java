package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-26 15:20
 * 链表的倒数第k个结点
 */
public class Demo22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i <= k; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
