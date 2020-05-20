package cqupt.leetCode.linkedList;

/**
 * @author yiLi
 * @create 2020-05-20 16:33
 * 奇偶链表
 */
public class T328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode o = head;// 奇链表的尾部
        ListNode e = head.next;// 偶链表的头部
        ListNode re = e;// 偶链表的尾部
        while (o.next != null && re.next != null) {
            o.next = re.next;
            o = o.next;// 不断改变链表尾部指针
            re.next = o.next;
            re = re.next;
        }
        // 出了上述while之后形成了奇偶两条链表
        o.next = e;// 将偶链表的头部接在奇链表的尾部后面
        return head;
    }
}
