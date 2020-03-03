package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-03 17:19
  合并两个有序链表
 */
public class T21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            }else {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        if (cur1 != null) {
            cur.next = cur1;
        }
        if (cur2 != null)
            cur.next = cur2;
        return dummy.next;
    }
}
