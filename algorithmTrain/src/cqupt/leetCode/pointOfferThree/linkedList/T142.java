package cqupt.leetCode.pointOfferThree.linkedList;

/**
 * @author yiLi
 * @create 2020-07-31 16:14
 * 找环形链表的入口
 */
public class T142 {
    // 假设起点到环入口的长度为a,环长度为b
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {// 这个while条件  不成环的话fast肯定会跑到null结点啊
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {// 第一次相遇时候  fast走了2s  slow走了s
                // 又fast比slow多走了nb(n个环的长度)
                // 得出fast走了2nb   slow走了nb
                // 只要从起点开始走 走a+nb长度肯定是环入口位置  所以让slow再走a长度就能到环入口位置
                // 并且此时让fast从起点走a长度也是环入口位置
                // 第二次相遇就能确定环入口位置
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
