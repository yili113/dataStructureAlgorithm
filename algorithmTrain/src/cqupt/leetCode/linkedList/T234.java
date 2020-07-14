package cqupt.leetCode.linkedList;

/**
 * @author yiLi
 * @create 2020-05-20 10:13
 * 回文链表
 * TODO
 */
public class T234 {
    public static boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode dummy = head;
        ListNode reHead = reverse(dummy);
        ListNode cur1 = head;
        ListNode cur2 = reHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val)
                return false;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next =head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (cur != null)
                next = cur.next;
        }
        return pre;
    }
    // 根据树结构进行判断回文链表
    public boolean isPalindrome1(ListNode head) {
        left = head;
        return reverse1(head);
    }

    private boolean reverse1(ListNode right) {
        if (right == null)
            return true;
        // 后序遍历
        boolean b = reverse1(right.next);// 此处b为false就说明当前结点的next结点是true的,后序遍历
        // 下面写后序遍历代码
        b = b && (left.val == right.val);
        left = left.next;
        return b;
    }

    private ListNode left;

}
