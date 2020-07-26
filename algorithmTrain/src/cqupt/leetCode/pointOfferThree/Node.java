package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-25 14:47
 * 双向链表结点类
 */
public class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
