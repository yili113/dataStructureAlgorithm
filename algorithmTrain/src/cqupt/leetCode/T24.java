package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-04 9:54
 */
public class T24 {


    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        dummy.next = head;
        swap(cur);
        return dummy.next;
    }

    /**
     * 交换cur后面的两个结点
     * @param cur 需要交换的两个结点的前一个结点
     */
    private void swap(ListNode cur) {
        while (cur.next != null && cur.next.next != null) {
            ListNode next = cur.next;
            ListNode nNext = next.next;
            // 交换的过程中保证没有结点丢失或者重复连接就行
            next.next = nNext.next;
            nNext.next = next;
            cur.next = nNext;
            // 不断更新cur的指向  指向下两个结点
            cur = cur.next.next;
        }
    }
}
