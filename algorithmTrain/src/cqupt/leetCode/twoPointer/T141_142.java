package cqupt.leetCode.twoPointer;

/**
 * @author Liyi
 * @create 2020-03-21 19:54
 */
public class T141_142 {

    public boolean hasCycle(ListNode head) {
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
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 此时slow指针已经走了nb步,再走a步就可以到环入口
                fast = head;// 而此时把fast指向开头,此时fast再走a步也能到环入口,所以在环入口时两指针会相遇(相遇的位置就是环入口)
                while (fast != slow) {
                    fast = fast.next;// 这次slow和fast每次走一步,走a次就会相遇(但是a不确定,只能通过相遇条件得出a)
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}
