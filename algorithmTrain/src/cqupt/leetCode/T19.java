package cqupt.leetCode;



/**
 * @author Liyi
 * @create 2020-03-03 15:40
 */
public class T19 {
    static ListNode dummy = new ListNode(0);
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode11 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        T19 t19 = new T19();
        t19.add(listNode1, listNode2);
//        t19.add(listNode1, listNode3);
        t19.add(listNode1, listNode4);
//        t19.add(listNode1, listNode5);
        t19.add(listNode11, listNode3);
        t19.add(listNode11, listNode4);
        t19.show(listNode1);
        t19.show(listNode11);
        T21 t21 = new T21();
        ListNode newHead = t21.mergeTwoLists(listNode1, listNode11);
        t19.show(newHead);
//        System.out.println(t19.getLength(listNode1));
/*        t19.removeNthFromEnd1(listNode1, 1);
        t19.show(dummy.next);*/
/*        ListNode head = t19.reverseNode(listNode1);
        t19.show(head);*/
    }
    /**
     * 思路：先找到倒数第n个结点 再删除
     * 要移动 len-n-1次到要删除的前一个
     *
     * 本地IDE正常 LeetCode报错编译错误
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);// 先得到链表的长度
        ListNode cur = head;
        for (int i = 0; i < len - n - 1; i++) {// 移动到需要删除结点的前一个
            cur = cur.next;
        }
/*        if (cur.next.next != null) {
            cur.next = cur.next.next;
        }else {
            cur.next = null;
        }*/
        cur.next = cur.next.next;
        return head;
    }

    /**
     * 得到链表的长度
     * @param head
     * @return
     */
    public int getLength(ListNode head) {
        if (head == null)
            return 0;
        int count = 0;
        ListNode cur = head;// 把头结点先保存起来
        while (cur.next != null) {
            count ++;
            cur = cur.next;
        }
        return count + 1;
    }

    /**
     * 添加结点
     * @param head
     * @param newNode
     */
    public void add(ListNode head, ListNode newNode) {
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;
    }

    /**
     * 显示链表
     * @param head
     */
    public void show(ListNode head) {
        ListNode cur = head;
        System.out.println(cur);
        while (cur.next != null) {
            cur = cur.next;
            System.out.println(cur);
        }
    }

    /**
     * 别人的思路!!!
     * 1.new一个dummy结点在head前面
     * 2.定义fast slow结点初始化指向dummy
     * 3.fast移动n次
     * 4.同时移动fast和slow直到fast指向最后一个
     * 5.此时slow指向的下一个就是需要删除的
     *
     * 类似滑窗，开始让fast移动n下，然后fast和slow间的距离一直不变，fast移到最后一个时，slow就是倒数第n个
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
//        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;

    }

    /**
     * 单链表的反转
     */
    public ListNode reverseNode(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode newHead = new ListNode(0);
        ListNode cur = dummy.next;
        ListNode next = null;
        /**
         * 关键就是：把newHead的后面的所有接到cur后面，再把整个cur接到newHead后面
         * 定义的next意义在于 防止原链表丢掉，因为cur是在原链表和新链表之间切换的
         */
        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }


}


