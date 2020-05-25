package cqupt.leetCode.practiceLinked;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-05-24 19:12
 * 翻转链表
 */
public class Demo3 {

    public ListNode reverse(ListNode head) {
        if (head == null)
            return head;
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        ListNode newHead = new ListNode(0);
        ListNode newCur = newHead;
        ListNode curNode = null;
        while (!stack.isEmpty()) {
            curNode = new ListNode(stack.pop());
            newCur.next = curNode;
            newCur = newCur.next;
        }
        return newHead.next;
    }
    public ListNode reverse1(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy.next;
        ListNode next = null;
        ListNode newHead = new ListNode(0);
        while(cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }
}
