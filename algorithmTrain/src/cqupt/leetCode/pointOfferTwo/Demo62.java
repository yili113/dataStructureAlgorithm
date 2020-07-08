package cqupt.leetCode.pointOfferTwo;

import java.util.ArrayList;

/**
 * @author yiLi
 * @create 2020-07-07 9:46
 */
public class Demo62 {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;// 找到要删除结点的位置,取余因为是循环链表
            list.remove(idx);
            n --;
        }
        return list.get(0);
    }
}
class Node62 {
    Node62 next;
    int val;

    public Node62(int val) {
        this.val = val;
    }
}
