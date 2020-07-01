package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-01 17:13
 */
public class Demo52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode l = headA;
        ListNode r = headB;
        while (l != r) {
            l = l.next;
            r = r.next;
            if (l == null && r == null)
                break;
            if (l == null) {
                l = headB;
            }
            if (r == null) {
                r = headA;
            }
        }
        return l;
    }
}
