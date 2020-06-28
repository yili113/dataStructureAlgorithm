package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-28 8:46
 */
public class Demo36 {
    // 最开始疑惑的是 怎么保存上一结点？
    // 定义链表的头尾两个结点引用
    // 动态更新尾部结点
    // 构成双向链表的时候就用尾部结点与新结点连接
    DoubleNode head = null;
    DoubleNode tail = null;
    public DoubleNode treeToDoublyList(DoubleNode root) {
        if (root == null)
            return null;
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void dfs(DoubleNode node) {
        if (node == null)
            return;
        // 中序遍历
        if (node.left != null)
            treeToDoublyList(node.left);

        if (head == null) {
            head = node;
            tail = node;
        }else {
            tail.right = node;
            node.left = tail;
            tail = node;
        }

        if (node.right != null)
            treeToDoublyList(node.right);
    }
}
class DoubleNode {
    public int val;
    public DoubleNode left;
    public DoubleNode right;

    public DoubleNode() {}

    public DoubleNode(int _val) {
        val = _val;
    }

    public DoubleNode(int _val,DoubleNode _left,DoubleNode _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
