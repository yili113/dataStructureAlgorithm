package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-31 11:01
 * 链表中倒数第k个节点
 */
public class Demo22 {
    // 双指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 1; i <= k; i++) {
            fast= fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
