package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-26 15:55
 */
public class Demo25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return null;
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ListNode curL = l1;
        ListNode curR = l2;
        while (curL != null && curR != null) {
            if (curL.val <= curR.val) {
                cur.next = curL;
                cur = cur.next;
                curL = curL.next;
            }else {
                cur.next = curR;
                cur = cur.next;
                curR = curR.next;
            }
        }
        if (curL != null)
            cur.next = curL;
        if (curR != null)
            cur.next = curR;
        return dummy.next;
    }
}
