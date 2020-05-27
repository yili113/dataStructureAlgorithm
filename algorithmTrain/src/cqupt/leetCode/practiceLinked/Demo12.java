package cqupt.leetCode.practiceLinked;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author yiLi
 * @create 2020-05-26 10:29
 * 删除无序链表中的重复元素
 */
public class Demo12 {

    // 这种思路肯定不行
    // set是无序的
    // 也就是说 取出来的顺序跟放进去的顺序不一样
    // 所以取出来重新组成链表的时候肯定顺序不对
    public ListNode deleteNode1(ListNode head) {
        if (head == null)
            return null;
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            set.add(cur.val);
            cur = cur.next;
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        ListNode newHead = new ListNode(0);
        cur = newHead.next;
        for (int i = 0; i < list.size(); i++) {
            ListNode newNode = new ListNode(list.get(i));
            cur.next = newNode;
            cur = newNode;
        }
        return newHead.next.next;
    }


    // hashSet用来判断该元素有没有过还行
    public ListNode deleteNode(ListNode head) {
        if(head == null)
            return null;
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = head;
        ListNode cur = pre.next;
        while (cur != null) {
            // 判断set中是否已经有了
            if (!set.contains(cur.val)) {
                set.add(cur.val);
                pre = cur;// 更新pre
            }else {
                pre.next = cur.next;// 删除cur这个结点
            }
            cur = cur.next;
        }
        return head;
    }

}
