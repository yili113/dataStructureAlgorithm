package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-29 15:40
 */
public class Demo06 {
    public int[] reversePrint(ListNode head) {
        if (head == null)
            return new int[]{};
        int len = getLen(head);
        int[] res = new int[len];
        ListNode cur = head;
        ListNode newHead = new ListNode(0);
        ListNode next = null;
        while (cur!= null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        cur = newHead.next;
        int index = 0;
        while (cur != null) {
            res[index ++] = cur.val;
            cur = cur.next;
        }
        return res;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len ++;
            head = head.next;
        }
        return len;
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

