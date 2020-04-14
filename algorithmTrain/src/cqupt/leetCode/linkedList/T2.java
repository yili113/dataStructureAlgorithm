package cqupt.leetCode.linkedList;

/**
 * @author Liyi
 * @create 2020-02-25 10:55
 * T2 两数相加---链表尾部对应高位
 */
public class T2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 以后做题记着先判断参数是否有效
        if (l1 == null)
            return l1;
        if (l2 == null)
            return l2;
        ListNode res = new ListNode(0);// 创建结果链表的头结点
        ListNode current = res;
        int carry = 0;// 表示进位的数
        // 两个链表对应结点上都有值
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;
            int val = sum % 10;
            carry = sum / 10;
            ListNode newNode = new ListNode(val);
            // 要把创建的结果新结点放在current后面 才能接着形成链表
            current.next = newNode;
            l1 = l1.next;
            l2 = l2.next;
            current = current.next;
        }
        // 经过上一个while  这个判断就是l2没结点了 只剩l1
        while (l1 != null) {
            int sum = l1.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode newNode = new ListNode(val);
            current.next = newNode;
            l1 = l1.next;
            current = current.next;
        }
        while (l2 != null) {
            int sum;
            sum = l2.val + carry;
            carry = sum / 10;
            int val = sum % 10;
            ListNode newNode = new ListNode(val);
            current.next = newNode;
            l2 = l2.next;
            current = current.next;
        }
        // 最后l1 l2都没了，但是还剩个进位 要创建个新结点接上去
        if (carry != 0) {
            current.next = new ListNode(carry);
//            current.next.val = carry;// 这种是错的 必须先new 对象  要不然空指针
        }
        return res.next;
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
