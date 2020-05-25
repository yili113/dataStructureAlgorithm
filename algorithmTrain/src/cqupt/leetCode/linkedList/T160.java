package cqupt.leetCode.linkedList;

/**
 * @author yiLi
 * @create 2020-05-20 8:43
 *
 * 链表A长度  a+c
 * 链表B长度  b+c
 * 假如说c是二者公共长度的话
 * 那么肯定会有 a+c+b+c = b+c+a+c
 * 也就是说A指针把两条链表走完的长度等于B指针把两条链表走完的长度
 * 这样才能满足上式
 * 如果c不存在就是  a+b = b+a
 */
public class T160 {
    // 画图理解
    // 假如两条链表有交点,最终l1=l2时候就是在那个交点
    // 如果没有交点,最终l1和l2都会走到null  这种情况也是l2=l1
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode res = null;
        if (headA == null || headB == null)
            return res;
        ListNode l1 = headA;
        ListNode l2 = headB;
        while (l1 != l2) {
            l1 = (l1 == null) ? headB : l1.next;
            l2 = (l2 == null) ? headA : l2.next;
        }
        return l1;
    }
}
