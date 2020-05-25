package cqupt.leetCode.practiceLinked;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-05-25 9:25
 * 判断链表的回文结构
 */
public class Demo6 {
    public boolean isHuiwen(ListNode head) {
        if (head == null)
            return false;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        Stack<Integer> stack = new Stack<>();
        ListNode cur = dummy.next;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        cur = dummy.next;
        while (!stack.isEmpty()) {
            if (stack.pop() != cur.val)
                return false;
            cur = cur.next;
        }
        return true;
    }
    // 没有额外的空间消耗
    public boolean isHuiwen1(ListNode head) {
        if (head == null)
            return true;
        ListNode n1 = head;
        ListNode n2 = head;
        while (n2.next != null && n2.next.next != null) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        // 如果长度为奇数的话,n1就是中点,偶数的话n1 n2中间是中点
        n2 = n1.next;// n2指向右半部分的开头
        n1.next = null;
        // 翻转右半部分
        ListNode n3 = null;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        // 翻转之后右半部分结点值没有改变,之间指向改成了从右向左指
        // 判断回文
        n2 = n1;
        n1 = head;// n1指向左半部分的开头   n2指向右半部分的结尾
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val)
                return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }
}
