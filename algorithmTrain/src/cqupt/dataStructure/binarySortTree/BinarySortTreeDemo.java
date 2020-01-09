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
