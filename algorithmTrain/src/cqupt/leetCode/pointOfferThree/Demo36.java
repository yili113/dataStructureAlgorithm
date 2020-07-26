package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-25 14:47
 * 二叉搜索树转成双向链表
 */
public class Demo36 {
    // 二叉搜索树中序遍历对应有序链表

    private Node head;// 链表头部
    private Node tail;// 链表尾部

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        helper(root);
        tail.right = head;
        head.left = tail;
        return head;
    }

    // 中序遍历
    private void helper(Node node) {
        if (node == null)
            return;
        if (node.left != null)
            helper(node.left);

        if (head == null) {
            head = node;
        }else {
            tail.right = node;
            node.left = tail;
        }
        tail = node;

        if (node.right != null)
            helper(node.right);
    }
}
