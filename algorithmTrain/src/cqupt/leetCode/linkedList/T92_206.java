package cqupt.leetCode.linkedList;

import java.util.Stack;

/**
 * @author Liyi
 * @create 2020-03-14 10:19
 */
public class T92_206 {


    /**
     * 简单的链表反转  思路1
     * @param head
     * @return
     */
/*    public ListNode reverseBetween(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode newHead = new ListNode(0);
        ListNode cur = dummy.next;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }*/

    /**
     * 简单的反转链表 思路2
     * @param head
     * @return
     */
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            cur.next = pre;// 直接把cur接到pre前面
            pre = cur;
            cur = next;
            if (cur != null)// 当cur有值时 才有新的next  next最多是null
                next = cur.next;
        }
        // 出上述while后  cur==null  next==null  此时pre指向的就是原链表的最后一个结点
        return pre;
    }

    /**
     * 简单的反转链表 ---stack
     * 不能向stack中直接存listNode,因为会造成链表的死循环，结点一直有next指针指向，而是要把val存入stack
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!stack.empty()) {
            int curNum = stack.pop();
            ListNode newNode = new ListNode(curNum);
            cur.next = newNode;
            cur = cur.next;
        }
        return dummy.next;
    }
    /**
     * 思路：不断让mNode接在nNode后面  直到mNode和nNode重合
     * @param head
     * @param m 需要反转范围的起始位置
     * @param n 需要反转范围的终止位置
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode mNode = dummy.next;
        ListNode nNode = dummy.next;
        // 1.分别将mNode和nNode移动特定位置
        // pre始终在mNode前
        for (int i = 1; i < m; i++) {// 移动m-1次
            pre = mNode;
            mNode = mNode.next;
        }
        for (int i = 1; i < n; i++) {
            nNode = nNode.next;
        }
        // 2.不断将mNode移动到nNode后面 直到重合
        while (mNode != nNode) {
            pre.next = mNode.next;
            mNode.next = nNode.next;
            nNode.next = mNode;
            // 此时不改变nNode  将mNode后移一位
            mNode = pre.next;// 这样两个结点才有机会重合
        }
        return dummy.next;
    }
}
