package cqupt.leetCode.practiceLinked;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-05-26 14:34
 * 二叉树变双向链表
 */
public class Demo14 {
    public Node covert(Node head) {
        if (head == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        inorder(head, queue);
        head= queue.poll();
        Node pre = head;// 得保存一下最开始的头
//        pre.left = null;
        Node cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = head;
        head.left = cur;
        return head;
    }

    private void inorder(Node head, Queue<Node> queue) {
        if (head == null)
            return;
        inorder(head.left, queue);
        queue.offer(head);
        inorder(head.right, queue);
    }
}

class Node {
    public int value;
    public Node left;
    public Node right;
    public Node(int data) {
        this.value = data;
    }
}


