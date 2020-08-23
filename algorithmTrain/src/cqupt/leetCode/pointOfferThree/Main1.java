package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-08-17 8:48
 * 链表的起始位置为数字的高位
 * 两数之和
 */
public class Main1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);

        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int carry = 0;
        int val = 0;
        int num = 0;
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while (cur1 != null && cur2 != null) {
            val = cur1.val + cur2.val + carry;
            num = val % 10;
            carry = val / 10;
            ListNode newNode = new ListNode(num);
            cur.next = newNode;
            cur = cur.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while (cur1 != null) {
            val = cur1.val + carry;
            num = val % 10;
            carry = val / 10;
            ListNode newNode = new ListNode(num);
            cur.next = newNode;
            cur = cur.next;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            val = cur2.val + carry;
            num = val % 10;
            carry = val / 10;
            ListNode newNode = new ListNode(num);
            cur.next = newNode;
            cur = cur.next;
            cur2 = cur2.next;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            cur.next = newNode;
        }
        return reverse(newHead.next);
    }

    private ListNode reverse(ListNode head) {
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

    private ListNode reverse1(ListNode head) {
        if (head.next == null)
            return head;
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }
}
