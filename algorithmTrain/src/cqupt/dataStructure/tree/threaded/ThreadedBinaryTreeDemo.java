package cqupt.dataStructure.tree.threaded;

/**
 * 线索化二叉树
 * 只有有空余指针域的结点才会有 前驱结点和后继结点  这是个前提   都是叶子结点
 * @author yiLi
 * @create 2020-01-06 16:14
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //创建需要的结点
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();// 将需要的结点线索化


        // HeroNode node5Left = node4.getLeft();
        System.out.println(node6.getLeft());
        // threadedBinaryTree.infixOrder();
        // threadedBinaryTree.threadedList();
    }
}

/**
 * 线索化二叉树类
 * 一个属性 表示根节点
 */
class ThreadedBinaryTree {
    private HeroNode root;
    // 为了实现线索化 需要一个指向当前结点前驱结点的引用
    private HeroNode pre = null;// 保留前一个结点
    public void setRoot(HeroNode root) {
        this.root = root;
    }

    /**
     * 对线索化后的树进行遍历  中序遍历
     */
    public void threadedList() {
        HeroNode node = root;
        // 遍历不管怎样都是从root开始找的
        // 后面这个node会改变的
        while (node != null) {
            // 先找到需要遍历的第一个结点
            // 第一个找到的leftType==1的就是第一个结点
            // 对于案例 第一个leftType==1的结点就是8
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            // 打印当前结点
            System.out.println(node);
            // 如果当前结点的右指针指向后继结点就一直输出
            while (node.getRightType() == 1) {
                // 获得当前结点的后继结点
                node = node.getRight();
                System.out.println(node);
            }
            // 替换正在遍历的结点
            node = node.getRight();
        }
    }

    // 对二叉树进行中序遍历线索化的方法
    // 线索化是对结点线索化
    /**
     * 重载
     */
    public void threadedNodes() {
        this.threadedNodes(root);
    }
    /**
     *
     * @param node 需要线索化的结点
     */
    public void threadedNodes(HeroNode node) {
        // 如果为空 就不能线索化
        if (node == null) {
            return;
        }
        // 中序遍历
        // 1.线索化左子树
        threadedNodes(node.getLeft());
        // 2.线索化当前结点 重点！
        // （1）处理前驱结点
        if (node.getLeft() == null) {// 左子树为空时候再考虑前驱结点
            // 此处需要注意:
            // 中序遍历的开头 8 结点的左子树是没有的
            // 所以需要设置前驱 但是现在pre是null 所以8结点的前驱是null
            // 但是8结点的setLeftType的还是设置为1 不影响
            // 后面找中序遍历的开头时候 就是根据第一个LeftType==1的结点作为开头的
            node.setLeft(pre);// pre表示当前结点node的前驱结点
            node.setLeftType(1);// 指向前驱结点而不是左子树
        }
        // （2）处理后继结点
        // !!! 处理当前结点的后继结点的时候是相对当前结点的后继结点来说的
        // 此处的pre是当前的结点的后继结点的pre 也就是当前结点
        // 因为是单向的 不能同时处理左右
        // 处理后继得递归回来之后处理
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);// 此时的node相当于是当前结点的后继结点
            pre.setRightType(1);
        }
        // !!!每处理一个结点，让当前结点是下一个结点的前驱结点
        pre = node;
        // 3.线索化右子树
        threadedNodes(node.getRight());
    }

    // 前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();// 调用节点的前序遍历方法
        }else {
            System.out.println("二叉树为空");
        }
    }
    // 中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    // 后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        }else {
            System.out.println("二叉树为空");
        }
    }
    // 前序遍历查找
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
            return this.root.preOrderSearch(no);// 调用节点的前序遍历方法
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }
    // 中序遍历查找
    public HeroNode infixOrderSearch(int no) {
        if (this.root != null) {
            return this.root.infixOrderSearch(no);// 调用节点的前序遍历方法
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }
    // 后序遍历查找
    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);// 调用节点的前序遍历方法
        }else {
            System.out.println("二叉树为空");
            return null;
        }
    }

    /**
     * 删除结点
     * 在此方法中判断root结点是否存在并且是否是要被删除的
     * @param no
     */
    public void deleteNode(int no) {
        if (root != null) {
            if (root.getNo() == no) {
                root = null;
            }else {
                root.deleteNode(no);// 这个地方调用的是结点类中的删除方法
            }
        }else {
            System.out.println("空树");
        }
    }
}

/**
 * 节点类
 */
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;
    // 规定  ==0表示指向左（右）子树 ==1表示指向前驱（后继）结点
    private int leftType;
    private int rightType;

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    /**
     * 前序遍历
     * 1.先输出父节点
     * 2.向左前序遍历
     * 3.向右前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     * 1.向左递归中序遍历
     * 2.输出父节点
     * 3.向右递归中序遍历
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

    /**
     * 后序遍历
     * 1.向左递归后序遍历
     * 2.向右递归后序遍历
     * 3.输出父节点
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     *  当进入结点的这个方法时 默认root结点有并且不是要被删除的
     * @param no 要删除结点的编号
     *           思路：
     *           1.因为我们的二叉树是单向的， 所以我们是判断当前结点的子结点是否需要删除结点， 而不能去判断
     * 当前这个结点是不是需要删除结点.
     *           2.如果当前结点的左子结点不为空， 并且左子结点 就是要删除结点， 就将 this.left = null; 并且就返回
     * (结束递归删除)
     *           3. 如果当前结点的右子结点不为空， 并且右子结点 就是要删除结点， 就将 this.right= null ;并且就返回
     * (结束递归删除)
     *           4. 如果第 2 和第 3 步没有删除结点， 那么我们就需要向左子树进行递归删除
     *           5. 如果第 4 步也没有删除结点， 则应当向右子树进行递归删除.
     */
    public void deleteNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        // 到了此处说明左右结点都不是要删除的  要进行递归了
        if (this.left != null) {
            this.left.deleteNode(no);
        }
        if (this.right != null) {
            this.right.deleteNode(no);
        }

    }

    /**
     *
     * @param no 节点的编号
     * @return 如果找到就返回该节点 没找到返回null
     */
    public HeroNode preOrderSearch(int no) {
        System.out.println("进入前序遍历");
        // 判断当前父节点是不是要找的
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;// 存放找到的结点
        if (this.left != null) {
            resNode = this.left.preOrderSearch(no);
        }
        if (resNode != null) {
            // 此时表明向左递归时找到
            return resNode;
        }
        // 开始向右递归
        if (this.right != null) {
            resNode = this.right.preOrderSearch(no);
        }
        // 此时返回的resNode可能是向右递归找到的 也可能是没找到的null
        return resNode;
    }

    /**
     * 中序遍历查找
     * @param no
     * @return
     */
    public HeroNode infixOrderSearch(int no) {
        HeroNode resNode = null;// 存放找到的结点
        if (this.left != null) {
            resNode = this.left.infixOrderSearch(no);
        }
        if (resNode != null) {
            // 此时表明向左递归时找到 找到就返回
            return resNode;
        }
        System.out.println("进入中序遍历查找");
        // 判断当前父节点是不是要找的
        if (this.no == no) {
            return this;
        }
        // 开始向右递归
        if (this.right != null) {
            resNode = this.right.infixOrderSearch(no);
        }
        // 此时返回的resNode可能是向右递归找到的 也可能是没找到的null
        return resNode;
    }

    /**
     * 后序遍历查找
     * @param no
     * @return
     */
    public HeroNode postOrderSearch(int no) {
        HeroNode resNode = null;// 存放找到的结点
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        if (resNode != null) {
            // 此时表明向左递归时找到 找到就返回
            return resNode;
        }
        // 开始向右递归
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        if (resNode != null) {
            // 此时表明向右递归时找到 找到就返回
            return resNode;
        }
        System.out.println("进入后序遍历查找");
        // 判断当前父节点是不是要找的
        if (this.no == no) {
            return this;
        }
        return resNode;
    }
}
