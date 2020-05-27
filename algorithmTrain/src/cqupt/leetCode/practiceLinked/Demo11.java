package cqupt.leetCode.practiceLinked;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-05-26 9:46
 */
public class Demo11 {

    // 栈实现 简单
    public ListNode reverseK(ListNode head, int k) {
        if (head == null || k < 1)
            return head;
        int len = getLen(head);
        int group = len / k;
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        ListNode newHead = new ListNode(0);
        ListNode newCur = new ListNode(0);
        newHead.next = newCur;
        for (int i = 0; i < group; i++) {
            while (stack.size() < 3) {
                System.out.println(cur.val);
                stack.push(cur.val);
                cur = cur.next;
            }
            while (!stack.isEmpty()) {
                ListNode newNode = new ListNode(stack.pop());
                newCur.next = newNode;
                newCur = newNode;
            }
        }
        if (cur != null) {
            newCur.next = cur;
        }
        return newHead.next.next;
    }

    // 常数额外空间
    // TODO
    public ListNode reverseK1(ListNode head, int k) {
        return null;
    }
    private int getLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count ++;
            head = head.next;
        }
        return count;
    }
}
