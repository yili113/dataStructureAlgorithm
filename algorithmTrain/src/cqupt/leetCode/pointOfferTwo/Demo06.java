package cqupt.leetCode.pointOfferTwo;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-06-23 9:20
 */
public class Demo06 {
    // stack
    public int[] reversePrint1(ListNode head) {
        if (head == null)
            return new int[]{};
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }
        int[] res = new int[stack.size()];
        int index = 0;
        while (!stack.isEmpty()) {
            res[index++] = stack.pop();
        }
        return res;
    }

    // 翻转
    public int[] reversePrint2(ListNode head) {
        if (head == null)
            return new int[]{};
        ListNode cur = head;
        ListNode newHead = new ListNode(0);
        ListNode next = null;
        int len = 0;
        while (cur != null) {
            len++;
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        int[] res = new int[len];
        int index = 0;
        cur = newHead.next;
        while (cur != null) {
            res[index++] = cur.val;
            cur = cur.next;
        }
        return res;
    }
    // 递归
    ArrayList<Integer> list = new ArrayList();
    public int[] reversePrint3(ListNode head) {
        if (head == null)
            return new int[]{};
        helper(head);
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void helper(ListNode head) {
        if (head == null)
            return;
        helper(head.next);
        list.add(head.val);
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
