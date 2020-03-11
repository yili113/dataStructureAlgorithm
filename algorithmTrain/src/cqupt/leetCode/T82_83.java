package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-10 10:24
 * 删除链表重复的结点
 */
public class T82_83 {


    /*    public ListNode deleteDuplicates(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode fast = head;
            ListNode slow = head.next;
            while (slow.next != null) {
                if (fast.val != slow.val) {
                    fast = fast.next;
                    slow = slow.next;
                }else {// 如果fast和slow指向的结点相等  就只移动slow
                    while (slow.next != null && slow.next.val == fast.val) {
                        slow = slow.next;
                    }
                    fast.next = slow.next;
                    slow = slow.next;
                }
            }
            if (fast.val == slow.val)
                fast.next = null;
            return head;
        }*/
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val)
                cur.next = cur.next.next;
            else
                cur = cur.next;
        }
        return head;
    }

    /**
     * 重复的元素全部删除  比如说2重复了 就把所有的2全部删除一个不留
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode realNode = dummy;// 指向最新的有效的结点
        ListNode preNode = dummy;// 指向当前结点的前一个结点
        ListNode curNode = head;// 指向当前结点
        while (curNode != null) {
            // 判断当前结点和前面结点、后面结点是否相同
            // curNode后面没有结点并且curNode和PreNode不等时 说明curNode也是有效结点
            if ((preNode == dummy || preNode.val != curNode.val) && (curNode.next == null || curNode.val != curNode.next.val)) {
                // 当前结点有效的话
                realNode.next = curNode;
                realNode = curNode;// 后移有效结点
            }
            preNode = curNode;
            curNode = curNode.next;
            preNode.next = null;// preNode的next要及时置空 避免指向无效的结点  例如 1->2->2
        }
        return dummy.next;
    }
}
