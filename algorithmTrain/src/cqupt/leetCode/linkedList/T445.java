package cqupt.leetCode.linkedList;

/**
 * @author yiLi
 * @create 2020-05-20 9:38
 * 逆序操作考虑用栈
 */
public class T445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);

        ListNode res = new ListNode(0);// 创建结果链表的头结点
        ListNode current = res;
        int carry = 0;// 表示进位的数
        // 两个链表对应结点上都有值
        while (rl1 != null && rl2 != null) {
            int sum = rl1.val + rl2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(val);
            // 要把创建的结果新结点放在current后面 才能接着形成链表
            current.next = newNode;
            rl1 = rl1.next;
            rl2 = rl2.next;
            current = current.next;
        }
        // 经过上一个while  这个判断就是l2没结点了 只剩l1
        while (rl1 != null) {
            int sum = rl1.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode newNode = new ListNode(val);
            current.next = newNode;
            rl1 = rl1.next;
            current = current.next;
        }
        while (rl2 != null) {
            int sum;
            sum = rl2.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode newNode = new ListNode(val);
            current.next = newNode;
            rl2 = rl2.next;
            current = current.next;
        }
        // 最后l1 l2都没了，但是还剩个进位 要创建个新结点接上去
        if (carry != 0) {
            current.next = new ListNode(carry);
//            current.next.val = carry;// 这种是错的 必须先new 对象  要不然空指针
        }
        ListNode newRes = res.next;
        return reverse(newRes);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode pre = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            if (cur != null)
                next = cur.next;
        }
        return pre;
    }
}
