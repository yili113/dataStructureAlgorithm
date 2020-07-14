package cqupt.leetCode.linkedList.reverse;

/**
 * @author yiLi
 * @create 2020-07-14 21:58
 * 反转 m-n个结点
 */
public class ReverseMN {



    public ListNode reverseMN(ListNode head, int m, int n) {
        if (m == 1)
            return reverseK(head,n);// base case:m=1时相当于反转前n个结点
        head.next = reverseMN(head.next, m - 1, n - 1);//
        return head;
    }
    public ListNode reverseK(ListNode head, int k) {
        if (k == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reverseK(head.next, k - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }
    private ListNode successor = null;
}
