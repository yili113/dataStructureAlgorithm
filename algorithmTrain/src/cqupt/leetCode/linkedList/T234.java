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

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4  = new ListNode(1);
        T19 t19 = new T19();
        t19.add(listNode1, listNode2);
        t19.add(listNode1, listNode3);
        t19.add(listNode1, listNode4);
        t19.show(listNode1);
        System.out.println("--------------------");
        ListNode reHead = reverse(listNode1);
        t19.show(reHead);
        System.out.println(isPalindrome(listNode1));
    }
}
