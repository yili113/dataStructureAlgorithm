package cqupt.leetCode.practiceLinked;

/**
 * @author yiLi
 * @create 2020-05-24 18:47
 */
public class DelMidNode {

    public ListNode deleteNode1(ListNode node) {
        if (node == null || node.next == null)
            return node;
        int len = getLen(node);
        ListNode cur = node;
        if (len % 2 == 1) {
            for (int i = 1; i < len / 2; i++) {// 奇数
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }else {// 偶数
            for (int i = 1; i < len / 2 - 1; i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return node;
    }

    private int getLen(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

}