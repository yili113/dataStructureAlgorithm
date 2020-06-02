package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-02 8:47
 */
public class Demo36 {
    private Node1 head;// 构成双向链表的头结点
    private Node1 lastNode;// 双向链表的尾结点,动态更新

    public Node1 treeToDoublyList(Node1 root) {
        if (root == null)
            return null;
        dfs(root, 0);
        head.left = lastNode;
        lastNode.right = head;
        return head;
    }
    // flag是个标志位:为0说明当前结点是根结点,上一个结点是左子结点;  为1说明当前结点是右子结点,上一结点是根结点
    private void dfs(Node1 node, int flag) {
        if (node == null)
            return;
        // 递归左子树
        if (node.left != null)
            dfs(node.left, 0);
        // 对当前结点的判断
        // 此时是对当前结点进行操作,这时候不用考虑结点的顺序
        // 大题框架是 中序遍历, 这时候对每个结点进行操作也是满足中序遍历的顺序的
        if (head == null) {// 这时候就是遍历到最左边的结点,中序遍历数组的第一个元素
            head = node;
            lastNode = node;
        }else {
            if (flag == 0) {
                node.left = lastNode;
                lastNode.right = node;
            }else if (flag == 1) {
                lastNode.right = node;
                node.left = lastNode;
            }
            lastNode = node;
        }
        // 递归右子树
        if (node.right != null)
            dfs(node.right, 1);
    }
}
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val,Node1 _left,Node1 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

