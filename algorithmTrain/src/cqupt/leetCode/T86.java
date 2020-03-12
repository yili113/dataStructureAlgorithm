package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-11 9:20
 * 分割链表
 */
public class T86 {


    /**
     * 自己容易想到的思路
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode cur1 = dummy1;
        ListNode cur2 = dummy2;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                cur1.next = cur;
                cur1 = cur1.next;
                cur = cur.next;// cur始终在原链表上 保证了原链表不丢失
                cur1.next = null;// !!!
            }else {
                cur2.next = cur;
                cur2 = cur2.next;
                cur = cur.next;
                cur2.next = null;// !!!一条链表分成两条链表的时候 要注意断开连接 容易造成死循环
                // 比如说 1-4-3-2-5-2  l1=1-2-2  l2=4-3-5  遍历到原链表最后一个结点时候cur指向的是l1中的
                // 所以说l2中的最近一次遍历的结点5的next还没删除 连着原链表的下一节点2(后来成为l1链表的结点2)
                // 合并之后就构成了  5-2-4-3的死循环
            }
        }
        // 当while循环后 两条链表分别保持原顺序
        cur1.next = dummy2.next;// 拼接两条链表
        return dummy1.next;
    }

    public static void main(String[] args) {
        T19 t19 = new T19();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode22 = new ListNode(2);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        t19.add(listNode1, listNode4);
        t19.add(listNode1, listNode3);
        t19.add(listNode1, listNode2);
        t19.add(listNode1, listNode5);
        t19.add(listNode1, listNode22);
        t19.show(listNode1);
        System.out.println("------------------");
        T86 t86 = new T86();
        ListNode partition = t86.partition(listNode1, 3);
        System.out.println("------------------");
        t19.show(partition);
    }
}
