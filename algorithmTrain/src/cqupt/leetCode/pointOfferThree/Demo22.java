package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-23 10:46
 * 链表中倒数第k个结点
 */
public class Demo22 {
    // 递归
    private int POS = 0;
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head.next == null)
            return head;
        ListNode last = getKthFromEnd(head.next, k);
        POS ++;
        if (POS == (k - 1))
            return head;
        int[] arr = new int[1];
        return last;
    }
}
