package cqupt.leetCode.practiceLinked;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-05-25 11:10
 * 两条链表相加
 * 尾部为低位
 */
public class Demo8 {
    public ListNode addLists(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null)
            return null;
        if (head2 == null)
            return head1;
        if (head1 == null)
            return head2;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2.val);
            head2 = head2.next;
        }
        int carry = 0;
        int sum = 0;
        ListNode cur = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            sum = carry + stack1.pop() + stack2.pop();
            int value = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(value);
            newNode.next = cur;// 头插法
            cur = newNode;
        }
        while (!stack1.isEmpty()) {
            sum = carry + stack1.pop();
            int value = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(value);
            newNode.next = cur;// 头插法
            cur = newNode;
        }
        while (!stack2.isEmpty()) {
            sum = carry + stack2.pop();
            int value = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(value);
            newNode.next = cur;// 头插法
            cur = newNode;
        }
        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            newNode.next = cur;// 头插法
            cur = newNode;
        }
        return cur;
    }
}
