package cqupt.leetCode.tree;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-05-22 16:25
 */
public class IsBST {


    // TODO
    public boolean isBst(TreeNode root) {
        if (root == null)
            return false;
        boolean res = true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode cur = root;
        TreeNode temp = root;
        while (!stack.isEmpty() || temp != null) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            temp = temp.right;
        }
        return res;
    }
    private int pre;
    public boolean isValidBST(TreeNode root) {
        pre = Integer.MIN_VALUE;
        return dfs(root);
    }
    private boolean dfs(TreeNode node) {
        if (node == null)
            return true;
        if (node.left != null)
            dfs(node.left);
        if (pre == Integer.MIN_VALUE) {
            pre = node.val;
        }else {
            if (node.val < pre)
                return false;
            pre = node.val;
        }
        if (node.right != null)
            dfs(node.right);
        return true;
    }
}
