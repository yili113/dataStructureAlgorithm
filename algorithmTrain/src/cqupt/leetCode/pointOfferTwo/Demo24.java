package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-26 15:25
 */
public class Demo24 {
    ListNode newHead = null;
    ListNode newCur = null;

    public ListNode reverseList1(ListNode head) {
        if (head == null)
            return null;
        this.newHead = new ListNode(0);
        this.newCur = newHead;
        recur(head);
        return newHead.next;
    }

    private void recur(ListNode head) {
        if (head == null)
            return;
        recur(head.next);
        newCur.next = head;
        newCur = head;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null)
            return null;
        ListNode cur = head;
        ListNode newHead = new ListNode(0);
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }
    // 递归
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 对于1->2->3->4->5而言
        // 递归到尾部时候 head是4  cur是5
        ListNode cur = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}