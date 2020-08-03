package cqupt.leetCode.pointOfferThree.linkedList;



/**
 * @author yiLi
 * @create 2020-07-31 15:13
 */
public class Demo52 {
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != curB) {
            // TODO
            curA = curA.next;
            curB = curB.next;
            if (curA == null && curB == null) {
                return null;
            }
            if (curA == null) {
                curA = headB;
            }
            if (curB == null) {
                curB = headA;
            }

        }
        return curA;
    }

    // 计算链表的长度 从后往前看找第一个相交的结点
    // 首先判断两个链表的尾结点是否相同 相同的话就往前找第一个相交的结点
    // 不相同的话就说明两条链表不相交
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != null) {
            lenA ++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB ++;
            curB = curB.next;
        }
        if (curA != curB)
            return null;
        curA = headA;
        curB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                curA = curA.next;
            }
        }else if (lenA < lenB) {
            for (int i = 0; i < lenB - lenA; i++) {
                curB = curB.next;
            }
        }
        while (curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}
