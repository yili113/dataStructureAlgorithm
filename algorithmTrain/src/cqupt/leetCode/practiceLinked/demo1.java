package cqupt.leetCode.practiceLinked;

/**
 * @author yiLi
 * @create 2020-05-24 16:52
 * 打印两个链表的公共部分
 */
public class demo1 {
    public void printLinked(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null)
            return;
        // 不需要重新定义dummy
        while (head1 != null && head2 != null) {
            if (head1.val == head2.val) {
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }else if (head1.val < head2.val) {
                head1 = head1.next;
            }else {
                head2 = head2.next;
            }
        }
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
