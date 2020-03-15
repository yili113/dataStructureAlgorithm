package cqupt.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Liyi
 * @create 2020-03-14 21:29
 * 树的中序遍历
 */
public class T94_144_145 {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root != null) {
            infixShow(result, root);
        }
        return result;
    }

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
     * 中序遍历----基于栈的迭代
     * 1.从根结点开始一直往下找左子树 不断把左子树push进栈
     * 2.把栈中的结点pop出来 加进结果集中 并且判断该结点的右子树是否有效(此时判断其右子树是因为
     * 中序遍历就是中间的遍历接着遍历右边的  也就是说把之前作为左子树push进栈的结点当做中间结点)
     * 3.需要把其右子树push进栈，检查其左子树
     *
     * 栈中元素：即将要处理的结点，但是还没来处理
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
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
}

