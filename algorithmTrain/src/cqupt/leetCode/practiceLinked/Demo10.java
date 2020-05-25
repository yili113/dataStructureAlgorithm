package cqupt.leetCode.practiceLinked;

/**
 * @author yiLi
 * @create 2020-05-25 15:07
 * 得到两条链表相交点的结点
 * 单向链表相交一定满足 从相交点开始到最后都是相交的
 * 因为一个结点只有一个后继结点
 * 也就是说 相交之后不能分叉了
 */
public class Demo10 {


    public ListNode getXiangjiao(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return null;
        int len1 = getLen(head1);
        int len2 = getLen(head2);
        ListNode end1 = getEnd(head1);
        ListNode end2 = getEnd(head2);
        if (end1 != end2)
            return null;
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {// cur1先走 len1-len2步
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            for (int i = 0; i < len1 - len2; i++) {// 先走 len1-len2步
                cur2 = cur2.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur2;
        }
    }

    private ListNode getEnd(ListNode head) {
        ListNode end = head;
        while (head.next != null) {
            end = head.next;
            head = end;
        }
        return end;
    }

    private int getLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count ++;
            head = head.next;
        }
        return count;
    }
}
