package cqupt.dataStructure.binarySortTree;

/**
 * 二叉排序树
 * @author yiLi
 * @create 2020-01-08 21:12
 */
public class BinarySortTreeDemo {
    public static void main(String[] args) {
        int[] arr = {7, 3, 10, 12, 5, 1, 9};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int i = 0; i < arr.length; i++) {
            binarySortTree.add(new Node(arr[i]));
        }
        binarySortTree.infixOrder();
    }
}

/**
 * 二叉排序树类
 */
class BinarySortTree {
    private Node root;

    /**
     * 添加
     * @param node
     */
    public void add(Node node) {
        if (root == null) {
            root = node;
        }else {
            root.add(node);
        }

    }
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }else {
            System.out.println("为空");
        }
    }
}
/**
 * 结点类
 */
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    /**
     *
     * @param value 希望删除的结点的值
     * @return 返回需要删除的结点 没找到的话就返回null
     */
    public Node search(int value) {
        if (this.value == value) {// 找到要删除的结点
            return this;// 放回找到的结点
        }else {
            if (this.value > value) {// 要找的结点在当前结点左边
                if (this.left != null) {// 左子结点存在 往左侧递归找
                    return this.left.search(value);
                }else {
                    return null;
                }
            }else {// 要找的结点在当前结点的右边
                if (this.right == null) {
                    return null;
                }else {
                    return this.right.search(value);
                }
            }
        }
    }

    /**
     * 查找需要删除结点的父结点
     * @param value 需要删除结点的值
     * @return 需要删除结点的父结点 没找到的话就返回null
     */
    public Node searchParent(int value) {
        if (this.left != null && this.left.value == value ||
            this.right != null && this.right.value == value) {
            return this;
        }else {
            if (value < this.value && this.left != null) {// 向左找
                return this.left.searchParent(value);
            }else if (value >= this.value && this.left != null) {
                return this.right.searchParent(value);
            }else {// 没找到父节点
                return null;
            }
        }
    }
    /**
     * 添加结点
     * @param node
     */
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (this.value > node.value) {// 向左添加
            if (this.left == null) {
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else {
            if (this.right == null) {
                this.right = node;
            }else {
                this.right.add(node);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (this.left != null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.infixOrder();
        }
    }
}
