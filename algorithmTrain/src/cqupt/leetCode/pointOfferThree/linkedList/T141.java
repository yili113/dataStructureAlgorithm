package cqupt.leetCode.pointOfferThree.linkedList;

/**
 * @author yiLi
 * @create 2020-07-31 15:45
 * 判断环形链表
 */
public class T141 {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {// 这个while条件  不成环的话fast肯定会跑到null结点啊
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}
