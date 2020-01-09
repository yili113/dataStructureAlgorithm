package cqupt.dataStructure.avlTree;

/**
 * @author yiLi
 * @create 2020-01-09 19:24
 * 要明白的是：在进行左右旋转的时候 调用那些旋转方法都是root结点调用的
 *     public void add(Node node) {
 *         if (root == null) {
 *             root = node;
 *         }else {
 *             root.add(node);
 *         }
 *     }
 * 添加结点时候是一个一个添加的，每添加一个都会进行是否旋转的判断
 * 所以！在形成AVL树的过程中不会出现左右子树高度差大于1
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
//        int[] arr = {4, 3, 6, 5, 7, 8};
        int[] arr = { 10, 11, 7, 6, 8, 9 };
        AVLTree avlTree = new AVLTree();
        for (int i = 0; i < arr.length; i++) {
            avlTree.add(new Node(arr[i]));
        }
        avlTree.infixOrder();
        // 查看树的高度
/*        System.out.println("树的高度" + avlTree.getRoot().height());
        System.out.println("左子树高度" + avlTree.getRoot().leftHeight());
        System.out.println("右子树高度" + avlTree.getRoot().rightHeight());*/
        System.out.println("树的高度=" + avlTree.getRoot().height()); //3
        System.out.println("树的左子树高度=" + avlTree.getRoot().leftHeight()); // 2
        System.out.println("树的右子树高度=" + avlTree.getRoot().rightHeight()); // 2
        System.out.println("当前的根结点=" + avlTree.getRoot());//8
    }
}
class AVLTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

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
     * 返回左子树的高度
     * @return
     */
    public int leftHeight() {
        if (left == null) {
            return 0;
        }else {
            return left.height();
        }
    }

    /**
     * 返回右子树的高度
     * @return
     */
    public int rightHeight() {
        if (right == null) {
            return 0;
        }else {
            return right.height();
        }
    }
    /**
     * 计算树的高度
     * @return 以当前结点为根 计算高度
     */
    public int height() {
        // 1.从左右子树中返回最大值
        // 2.左子树要是为空就返回0 不然就返回左子树的高度 递归实现
        return Math.max(left==null ? 0 : left.height(), right == null ? 0 : right.height()) + 1;
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
        // 当添加一个结点后要判断是否需要旋转
        // 旋转的条件是 添加完一个结点之后，左右子树高度差>1
        if (rightHeight() - leftHeight() > 1) {
            // 如果它的右子树的   左子树高度大于右子树高度
            if (right != null && right.leftHeight() > right.rightHeight()) {
                // 先对当前结点的右结点 进行右旋转
                right.rightRotate();
                // 再对当前结点进行左旋转
                leftRotate();
            }else {
                // 直接进行左旋转
                leftRotate();
            }
            return;// 这个return必须有  因为这个方法是加一个结点进行操作一次
            // 不可能上面进行完了再接着进行下面的
        }
        if (leftHeight() - rightHeight() > 1) {
            // 如果它的左子树的   右子树高度大于左子树高度
            if (left != null && left.rightHeight() > left.leftHeight()) {
                // 先对当前结点的左结点 进行左旋转
                left.leftRotate();
                // 再对当前结点进行右旋转
                rightRotate();
            }else {
                // 直接进行右旋转
                rightRotate();
            }
        }
    }

    /**
     * 右旋转
     * 1.创建一个新的结点 值等于当前根结点的值
     * 2.把新结点的右子树设置为当前结点的右子树
     * 3.把新结点的左子树设置为当前结点的左子树的右子树
     * 4.把当前结点的值换为左子结点的值
     * 5.把当前结点的左子树设置为左子树的左子树
     * 6.把当前结点的右子树设置为新结点
     */
    private void rightRotate() {
        Node newNode = new Node(value);
        newNode.right = right;
        newNode.left = left.right;
        value = left.value;
        left = left.left;
        right = newNode;
    }

    /**
     * 左旋转
     * 1.创建一个新的结点 值等于当前根结点的值
     * 2.把新结点的左子树设置成当前结点的左子树
     * 3.把新结点的右子树设置为当前结点的右子树的左子树
     * 4.把当前结点的值换为右子结点的值
     * 5.把当前结点的值换为右子树的右子树
     * 6.把当前结点的左子树设置为新结点
     */
    private void leftRotate() {
        // 1.
        Node newNode = new Node(value);// 谁调用用谁的值
        // 2.
        newNode.left = left;
        // 3.
        newNode.right = right.left;
        // 4.
        value = right.value;
        // 5.
        right = right.right;
        // 6.
        left = newNode;
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
