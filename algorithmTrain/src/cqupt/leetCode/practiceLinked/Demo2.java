package cqupt.leetCode.practiceLinked;

/**
 * @author yiLi
 * @create 2020-05-24 16:58
 * 删除链表中的倒数第K个结点
 */
public class Demo2 {
    public ListNode removeK(ListNode head, int K) {
        if (head == null)
            return head;
        int len = getLen(head);
        ListNode dummy = new ListNode(0);
        if (len == 1 && K == 1)
            return null;
        dummy.next = head;
        if (len == K) {
            dummy.next = dummy.next.next;
            return dummy.next;
        }
        ListNode cur = head;
        for (int i = 1; i < len - K; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }

    private int getLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count ++;
            head = head.next;
        }
        return count;
    }

}
