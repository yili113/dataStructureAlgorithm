package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-01 17:06
 */
public class Demo35 {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node newHead = new Node(0);
        Node curOri = head;
        Node curNew = newHead;
        while (curOri != null) {
            Node cur = new Node(curOri.val);
            curNew.next = cur;
            curNew = cur;// curNew后移
            curOri = curOri.next;
        }
        // 此时新链表保存了原链表的顺序和值,现在需要把random指针加上
        curOri = head;
        curNew = newHead.next;
        while (curOri != null) {
           if (curOri.random != null) {
               Node cur = curNew.next;
               while (cur != null) {
                   if (cur == curOri.random)
                       break;
                   cur = cur.next;
               }
               curNew.random = cur;
               curNew = curNew.next;
               curOri = curOri.next;
           }else {
               curNew = curNew.next;
               curOri = curOri.next;
           }
        }
        return newHead.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
