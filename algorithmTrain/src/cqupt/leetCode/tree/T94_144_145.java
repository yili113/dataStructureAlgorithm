package cqupt.leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Liyi
 * @create 2020-03-14 21:29
 * 树的中序遍历
 */
public class T94_144_145 {

    /**
     * 中序遍历
     * 递归！
     * @param result
     * @param root
     */
    private void infixShow(ArrayList<Integer> result, TreeNode root) {
        if (root.left != null) {
            infixShow(result, root.left);
        }
        result.add(root.val);
        if (root.right != null)
            infixShow(result, root.right);
    }

    public void infixPrint(TreeNode root) {
        if (root.left != null) {
            infixPrint(root.left);
        }
        System.out.println(root);
        if (root.right != null)
            infixPrint(root.right);
    }
    public void postPrint(TreeNode root) {
        if (root.left != null) {
            postPrint(root.left);
        }
        if (root.right != null) {
            postPrint(root.right);
        }
        System.out.println(root);
    }

    /**
     * 中序遍历---基于栈的迭代
     * 1.从根结点开始一直往下找左子树 不断把左子树push进栈
     * 2.把栈中的结点pop出来 加进结果集中 并且判断该结点的右子树是否有效(此时判断其右子树是因为
     * 中序遍历就是中间的遍历接着遍历右边的  也就是说把之前作为左子树push进栈的结点当做中间结点)
     * 3.需要把其右子树push进栈，检查其左子树
     *
     * 栈中元素：即将要处理的结点，但是还没来处理
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {// 一直顺着左子树找 先都放进栈中
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;// 此时有右子树就会进入新的大循环
        }
        return result;
    }

    /**
     * 前序遍历---迭代---基于stack
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack stack = new Stack<Integer>();
        stack.push(root);// 因为是前序遍历,根结点可以直接就先入栈了
        while (!stack.empty()) {
            TreeNode cur = (TreeNode) stack.pop();
            while (cur != null) {
                if (cur.right != null) {
                    stack.push(cur.right);// 遇到右结点直接先push 稍后处理
                }
                // 前序遍历关键：先把cur放到结果集中，再把cur更新成左结点
                res.add(cur.val);
                cur = cur.left;// 一直向左找 当前根结点的左节点作为下一次的根结点
            }
        }
        return res;
    }

    /**
     * 后序遍历---迭代
     * 要明白:不是一直将根结点加入结果集,而是一直迭代,最先加入结果集的那个根结点已经没有左右子树了,它就相当于上一层的左子结点/右子结点
     * p结点为T说明p是右子结点访问过了返回出的根结点,加进结果集(此时p的左右子结点都已经加入结果集了,因为其左右子结点在栈中时候在p的上方)
     * 第一次访问结点p是向下遍历的时候,这时候是把p当成左子结点来遍历的,此时将结点p置为false,接着访问p的左子结点
     * 当开始从栈中peek元素时候,弹出cur结点,当cur结点有右子结点时候,就将p指向cur的右子结点,此时将cur置为true(代表cur的左右子结点都没访问过了)
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        Stack<ssNode> stack = new Stack<>();
        TreeNode p = root;
        do {
            while (p != null) {
                stack.push(new ssNode(p, false));
                p = p.left;
            }
            while (!stack.empty()) {
                ssNode cur = stack.pop();
                if (cur.flag) {// flag为true表明这个结点是从下往上遍历的
                    res.add(cur.pos.val);
                }else {// flag为false表明这个结点是从上往下遍历的
                    p = cur.pos.right;// 将cur的右子结点赋给p,继续循环
                    // 再把cur放回去
                    stack.push(new ssNode(cur.pos, true));
                    break;// 此时break跳出当前的while,进入到一个判断p是否为空的新的大循环
                }
            }
        }while (!stack.empty());
        return res;
    }
}
class ssNode {
    TreeNode pos;
    boolean flag;
    public ssNode(TreeNode pos, boolean flag) {
        this.pos = pos;
        this.flag = flag;
    }
}

