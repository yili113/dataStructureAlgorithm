package cqupt.dataStructure.tree;

/**
 * @author yiLi
 * @create 2020-01-06 16:14
 */
public class BinaryTreeDemo {
    public static void main(String[] args) {
        //先需要创建一颗二叉树
        BinaryTree binaryTree = new BinaryTree();
        //创建需要的结点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");
        //说明， 我们先手动创建该二叉树， 后面我们学习递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node2.setRight(node4);
        node2.setLeft(node5);


        // 声明二叉树的根节点
        binaryTree.setRoot(root);
        // 测试
/*        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后序遍历");
        binaryTree.postOrder();*/
//        System.out.println(binaryTree.infixOrderSearch(5));
        binaryTree.preOrder();
        binaryTree.deleteNode(5);
        binaryTree.preOrder();
    }
}

/**
 * 二叉树类
 * 一个属性 表示根节点
 */
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
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
