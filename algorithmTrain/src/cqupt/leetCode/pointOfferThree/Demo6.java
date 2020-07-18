package cqupt.leetCode.pointOfferThree;

import java.util.ArrayList;

/**
 * @author yiLi
 * @create 2020-07-18 12:19
 */
public class Demo6 {

    private ArrayList<Integer> list = new ArrayList<>();
    // 递归
    public int[] reversePrint(ListNode head) {
//        int fisrt = head.val;
        helper1(head);
//        list.add(fisrt);
        int len = list.size();
        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void helper1(ListNode head) {
        if (head == null)
            return;
        helper1(head.next);
        list.add(head.val);
    }

    private ListNode helper(ListNode head) {
        if (head.next == null)
            return head;
        ListNode last = helper(head.next);
        list.add(last.val);
        return head;
    }
}
