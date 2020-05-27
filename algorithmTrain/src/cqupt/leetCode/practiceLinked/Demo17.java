package cqupt.leetCode.practiceLinked;

/**
 * @author yiLi
 * @create 2020-05-27 9:57
 * 有序非减链表中添加新结点
 */
public class Demo17 {
    // 自己实现的比较乱
    // 没有考虑把newHead放在pre和cur中间
    // 没有考虑到 新加的结点比原本所有结点都小的情况,此时拼接上newHead之后要返回新结点而不是head
    public ListNode insertNode1(ListNode head, int num) {
        if (head == null)
            return new ListNode(num);
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && cur.val < num && cur.next.val > cur.val) {
            pre = cur;
            cur = cur.next;
        }
        if (cur.val < num) {// 到末尾
            ListNode newNode = new ListNode(num);
            cur.next = newNode;
            newNode.next = head;
        } else {
            ListNode newNode = new ListNode(num);
            newNode.next = cur;
            pre.next = newNode;
        }
        return head;
    }
    // 利用pre和cur的大小决定newHead放在哪
    public ListNode insertNode(ListNode head, int num) {
        ListNode newNode = new ListNode(num);
        if (head == null) {
            newNode.next = newNode;// 自己一个结点构成环形返回
            return newNode;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != head) {// cur==head表示循环了一圈
            if (pre.val <= num && cur.val >= num)
                break;
            pre = cur;
            cur = cur.next;
        }
        // 此时新结点要放在pre和cur中间
        newNode.next = cur;
        pre.next = newNode;
        return num > head.val ? head : newNode;
    }

}
