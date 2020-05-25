package cqupt.leetCode.practiceLinked;

/**
 * @author yiLi
 * @create 2020-05-25 14:42
 * 链表成环判断
 * 并且找到环的入口
 */
public class Demo9 {
    public boolean isHuan(ListNode head) {
        if (head == null || head.next == null)
            return false;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
    public ListNode getHuan(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {// 如果fast==slow就说明链表是成环的
                // 此时fast肯定是走了 a+nb步   slow走了 nb步
                // 所以让fast从头开始走
                // 二者每次都是走一步 也就是都走了 a步之后肯定会在 环入口相遇
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
