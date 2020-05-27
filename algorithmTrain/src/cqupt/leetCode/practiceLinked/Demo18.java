package cqupt.leetCode.practiceLinked;

/**
 * @author yiLi
 * @create 2020-05-27 10:45
 * 按照左右半区的方式重新组合链表
 */
public class Demo18 {
    public ListNode relocate(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode mid = head;
        ListNode right = head.next;
        // 找链表中点的方式
        // 不要再用getLen的方式啦！
        while (right.next != null && right.next.next != null) {
            mid = mid.next;
            right = right.next.next;
        }
        // 以上出来的结果如果链表长度是奇数的话  mid.next 才是中间那个结点
        // 如果是偶数的话 mid.next 右半部分的开头
        right = mid.next;
        mid.next = null;
        head = mergeLR(head, right);
        return head;
    }

    private ListNode mergeLR(ListNode left, ListNode right) {
        ListNode res = new ListNode(0);
        res.next = left;
        ListNode next = null;
        while (right != null) {
            next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = next;
        }
        return res.next;
    }
}
