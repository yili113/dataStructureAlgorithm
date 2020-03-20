package cqupt.leetCode.linkedList;

/**
 * @author Liyi
 * @create 2020-03-08 14:14
 */
public class T61 {


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        // 计算链表的长度
        // k很大时候 只需取余就能得到真实需要移动的次数
//        while (fast.next != null) { // 这种计算长度会少1
        while (fast != null) {
            len ++;
            fast = fast.next;
        }
        fast = head;
        for (int i = 0; i < k % len; i++) {// 先将fast移动k%len次
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 此时slow指向的下一个结点就是新链表的头部
        fast.next = head;// 1.将fast接到旧head前面
        head = slow.next;// 2.将新head指向slow的下一个
        slow.next = null;// 3.表示slow指向的结点为新的尾部
        return head;
    }
    public void show(ListNode head) {
        ListNode cur = head;
        System.out.println(cur);
        while (cur.next != null) {
            cur = cur.next;
            System.out.println(cur);
        }
    }

    public static void main(String[] args) {

    }
}
