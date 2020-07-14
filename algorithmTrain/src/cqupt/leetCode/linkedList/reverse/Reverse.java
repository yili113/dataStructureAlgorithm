package cqupt.leetCode.linkedList.reverse;

/**
 * @author yiLi
 * @create 2020-07-14 19:49
 */
public class Reverse {
    // 1->2->3->4
    // 一直递归到底
    // 最终head是4   last是5
    public ListNode reverse(ListNode head) {
        if (head.next == null)
            return head;
        ListNode last = reverse(head.next);// 每次last都会指向反转之后新的头结点
        head.next.next = head;
        head.next = null;// head成为链表的尾结点,尾结点的next当然要置null
        return last;
    }
}