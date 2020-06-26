package cqupt.leetCode.pointOfferTwo;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-06-26 16:16
 */
public class Demo27 {
    // 递归
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = mirrorTree1(root.left);
        root.left = mirrorTree1(root.right);
        root.right = temp;
        return root;
    }
    // 迭代
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null)
                stack.push(cur.left);
            if (cur.right != null)
                stack.push(cur.right);
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
        }
        return root;
    }
}