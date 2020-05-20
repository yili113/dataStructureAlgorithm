package cqupt.leetCode.linkedList;

/**
 * @author yiLi
 * @create 2020-05-20 11:15
 */
public class Test11 {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int N = 0;
        ListNode cur = root;
        while (cur != null) {
            N++;
            cur = cur.next;
        }
        int mod = N % k;
        int size = N / k;
        ListNode[] ret = new ListNode[k];
        cur = root;
        for (int i = 0; cur != null && i < k; i++) {
            ret[i] = cur;
            int curSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ret;
    }
}
