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
}
