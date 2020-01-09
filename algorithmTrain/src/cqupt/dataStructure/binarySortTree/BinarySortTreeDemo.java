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
        binarySortTree.deleteNode(12);
        binarySortTree.deleteNode(5);
        binarySortTree.deleteNode(10);
        binarySortTree.deleteNode(2);
        binarySortTree.deleteNode(3);
        binarySortTree.deleteNode(9);
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

    /**
     * 中序遍历
     */
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        }else {
            System.out.println("为空");
        }
    }

    /**
     * 删除结点
     * 第一种情况：要删除的结点是叶子结点
     * 1.找到要删除的结点和其父结点
     * 2.判端结点是其父结点的左子结点还是右子结点
     * 3.然后将其父结点的左子结点或者右子结点置空
     *
     * 第二种情况：要删除的结点（targetNode）有一个子结点
     * 1.targetNode有左子结点
     *  11.判断targetNode是其父结点的左子结点还是右子结点
     *  若是其父结点的左子结点 则parent.left = targetNode.left
     *  右同理
     * 2.targetNode有右子结点
     *  21.判断targetNode是其父结点的左子结点还是右子结点
     *  若是其父结点的左子结点 则parent.left = targetNode.right
     *
     * 第三种情况：要删除的结点有两个子结点
     * (1) 需求先去找到要删除的结点 targetNode
     * (2) 找到 targetNode 的 父结点 parent
     * (3) 从 targetNode 的右子树找到最小的结点
     * (4) 用一个临时变量， 将 最小结点的值保存 temp = 11
     * (5) 删除该最小结点
     * (6) targetNode.value = temp
     *
     * @param value 需要删除结点的那个值
     */
    public void deleteNode(int value) {
        if (root == null) {
            return;
        }else {
            // 找到需要删除的结点 targetNode
            Node targetNode = search(value);
            // 如果没有找到要删除的结点
            if (targetNode == null) {
                return;
            }
            // 如果发现这个二叉树只有一个结点 就是根结点
            if (root.left == null && root.right ==null) {
                root = null;// 删除根结点
                return;
            }
            // 找父结点
            Node parent = searchParent(value);
            // 第一种情况 要删除的结点是叶子结点
            if (targetNode.left == null && targetNode.right == null) {
                // 判断该结点是父结点的左子结点还是右子结点
                if (parent.left != null && parent.left.value == value) {
                    parent.left = null;// 是父结点的左子结点的话 就让其左子结点置空
                }else if (parent.right != null && parent.right.value == value) {
                    parent.right = null;
                }
            } else if (targetNode.left != null && targetNode.right != null) {
                // 第二种情况 要删除的结点有两个子结点
                int minVal = delRightTreeMin(targetNode.right);
                targetNode.value = minVal;
            }else {
                // 第三种情况 要删除的结点只有一个子结点
                // 1.targetNode有左子结点
                if (targetNode.left != null) {
                    if (parent != null) {
                        // 11.targetNode是parent的左子结点
                        if (parent.left.value == value) {
                            parent.left = targetNode.left;
                        }else {
                            parent.right = targetNode.left;
                        }
                    } else {// 该结点没有父结点的话 说明其是根结点
                        root = targetNode.left;// ！！！很关键，假设只剩下两个结点的时候，此时要删除根结点没有这句话就会错，根结点无父结点
                    }
                }else if (targetNode.right != null) {// 2.targetNode有右子结点
                    if (parent != null) {
                        // 21.targetNode是parent的左子结点
                        if (parent.left.value == value) {
                            parent.left = targetNode.right;
                        }else {
                            parent.right = targetNode.right;
                        }
                    }else {
                        root = targetNode.right;
                    }
                }
            }
        }
    }

    /**
     * 当要删除的结点（targetNode）有两个子结点的时候，从targetNode的右子树不断遍历
     * 找到右子树中左子结点最小的那个结点tempNode 将这个结点置于targetNode的位置就不会改变二叉排序树结构
     * @param targetNode
     * @return 返回的是找到的最小左子结点的值 将值置于要删除那个结点
     */
    private int delRightTreeMin(Node targetNode) {
        Node target = targetNode;
        // 循环的查找左子节点， 就会找到最小值
        while(target.left != null) {
            target = target.left;
        } // 这时 target 就指向了最小结点
        // 删除最小结点
        deleteNode(target.value);
        return target.value;
    }

    /**
     * @param value
     * @return
     */
    public Node search(int value) {
        if (root == null) {
            return null;
        }else {
            return root.search(value);
        }
    }

    /**
     * 查找需要删除结点的父结点
     * @return
     */
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }else {
            return root.searchParent(value);
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
