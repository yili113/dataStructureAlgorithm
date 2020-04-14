package cqupt.leetCode.linkedList;

import java.util.Stack;

/**
 * @author Liyi
 * @create 2020-04-14 22:05
 * 两数相加--链表尾部对应低位
 * 逆序操作---->stack
 */
public class T445_addNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l1;
        if (l2 == null)
            return l2;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        ListNode cur = null;
        int carry = 0;// 表示进位
        while (!stack1.empty() && !stack2.empty()) {
            int sum = stack1.pop() + stack2.pop() + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(val);
//            cur.next = newNode;
//            cur = cur.next;
            newNode.next = cur;// 关键地方！
            cur = newNode;
        }
        while (!stack1.empty()) {// 要是进了while就表示stack1不空 stack2空
            int sum = stack1.pop() + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(val);
            newNode.next = cur;
            cur = newNode;
        }
        while (!stack2.empty()) {// 要是进了while就表示stack2不空 stack1空
            int sum = stack2.pop() + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(val);
            newNode.next = cur;
            cur = newNode;
        }
        if (carry != 0) {
//            cur.next = new ListNode(carry);
            ListNode newNode = new ListNode(carry);
            newNode.next = cur;
            cur = newNode;
        }
        return cur;
    }
}
