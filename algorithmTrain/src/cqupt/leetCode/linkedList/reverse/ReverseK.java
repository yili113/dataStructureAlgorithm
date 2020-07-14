package cqupt.leetCode.linkedList.reverse;

/**
 * @author yiLi
 * @create 2020-07-14 20:22
 * 反转前k个结点
 */
public class ReverseK {
    // 当k==3
    // 1  ->  2  -> 3  -> 4  ->  5
    // k=3    k=2   k=1
    // successor=4
    // 在last=3的时候head=2
    private ListNode successor = null;

    public ListNode reverseK(ListNode head, int k) {
        if (k == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseK(head.next, k - 1);// last为反转之后的头
        head.next.next = head;// 让3的next指向2
        head.next = successor;// head为反转之后的尾
        return last;
    }
}
