package cqupt.leetCode.pointOfferTwo;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-06-28 8:32
 * 复杂链表的复制
 */
public class Demo35 {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node node = new Node(cur.val);// 为每个复制的结点创建空间
            map.put(cur,node);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node temp = map.get(cur);// 拿到复制出的新结点
            temp.next = map.get(cur.next);
            temp.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head) == null ? null : map.get(head);
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
