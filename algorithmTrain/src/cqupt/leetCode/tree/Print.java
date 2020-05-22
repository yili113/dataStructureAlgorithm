package cqupt.leetCode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-05-20 21:24
 */
public class Print {

    /**
     * 前序遍历迭代方法主要是利用栈的先进后出的特性
     * 先操作根结点
     * 然后再将右结点先放入栈,左结点后放入栈
     * 因为先放进栈的后使用
     * 也就是先操作左结点,后操作右结点
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null)
            stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            list.add(cur.val);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    /**
     * 双栈
     * 主要思想就是：s2中先放进去的肯定后操作,后序遍历
     * 所以对于当前结点的子结点来说,当前结点肯定是要最后操作的
     * 所以从s1中弹出的当前结点就要放进s2中
     * 并且将当前结点的左右子结点此次放进s1中
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        s1.push(root);
        while (!s1.empty()) {
            TreeNode cur = s1.pop();
            s2.push(cur);
            if (cur.left != null)
                s1.push(cur.left);
            if (cur.right != null)
                s1.push(cur.right);
        }
        while (!s2.empty())
            res.add(s2.pop().val);
        return res;
    }
}
