package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-08-20 10:49
 */
public class IsPalindrome {
    // 双指针判断回文链表
    public boolean isPalindrome(ListNode head) {
        left = head;
        return helper(head);
    }
    private ListNode left;

    private boolean helper(ListNode right) {
        if (right == null)
            return true;
        boolean res = helper(right.next);
        res = res & left.val == right.val;
        left = left.next;
        return  res;
    }

    public static void main(String[] args) {
        IsPalindrome test = new IsPalindrome();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        System.out.println(test.isPalindrome(head));
    }
}
