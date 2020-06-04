package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-04 19:56
 */
public class Demo52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            if (curA != null)
                curA = curA.next;
            else
                curA = headB;
            if (curB != null)
                curB = curB.next;
            else
                curB = headA;
        }
        return curA;
    }
}
