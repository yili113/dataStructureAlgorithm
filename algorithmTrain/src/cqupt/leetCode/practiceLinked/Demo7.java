package cqupt.leetCode.practiceLinked;

/**
 * @author yiLi
 * @create 2020-05-25 10:12
 * 调整链表内部顺序,使左侧的结点值小于pivot,中间值等于,右边值大于
 * 自己思路：
 * 根据值的大小放入三个不同的队列,然后进行拼接,这样不会乱序
 */
public class Demo7 {
    public ListNode adjust(ListNode head, int pivot) {
        if (head == null)
            return null;
        ListNode lStart = null;
        ListNode lEnd = null;
        ListNode pStart = null;
        ListNode pEnd = null;
        ListNode bStart = null;
        ListNode bEnd = null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            if (cur.val < pivot) {
                if (lStart == null) {
                    lStart = cur;
                    lEnd = cur;
                }else {
//                    lEnd = lEnd.next;
//                    lEnd = cur;
                    lEnd.next = cur;
                    lEnd = cur;
                }
            }else if (cur.val > pivot) {
                if (bStart == null) {
                    bStart = cur;
                    bEnd = cur;
                }else {
                    bEnd = bEnd.next;
                    bEnd = cur;
                }
            }else {
                if (pStart == null) {
                    pStart = cur;
                    pEnd = cur;
                }else {
                    pEnd = pEnd.next;
                    pEnd = cur;
                }
            }
            cur = next;
        }
        // 合并
//        dummy.next = lStart;
//        lEnd.next = pStart;
//        pEnd.next = bStart;
        if (lEnd != null) {
            lEnd.next = pStart;
            if (pEnd == null) {
                pEnd = lEnd;
            }else {
                pEnd = pEnd;
            }
        }
        if (pEnd != null) {
            pEnd.next = bStart;
        }
        return lStart != null ? lStart : pStart != null ? pStart : bStart;
    }
}
