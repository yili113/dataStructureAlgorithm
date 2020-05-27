package cqupt.leetCode.practiceLinked;

/**
 * @author yiLi
 * @create 2020-05-26 11:25
 * 删除链表中指定数值的结点
 */
public class Demo13 {
    public ListNode removeNode(ListNode head, int num) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummy;
        pre.next = cur;
        while (cur != null) {
            if (cur.val == num) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
