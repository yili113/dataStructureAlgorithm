package cqupt.leetCode.pointOfferThree;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-07-24 13:30
 * 树的镜像
 */
public class Demo27 {
    // 递归
    public TreeNode mirrorTree1(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = null;
        temp = mirrorTree1(root.left);
        root.left = mirrorTree1(root.right);
        root.right = temp;
        return root;
    }

    // 迭代
    // 迭代的方式就是一个结点一个结点去遍历,然后交换其左右子结点
    public TreeNode mirrorTree2(TreeNode root) {
        if (root == null)
            return null;
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while (!s.isEmpty()) {
            TreeNode cur = s.pop();
            if (cur.left != null)
                s.push(cur.left);
            if (cur.right != null)
                s.push(cur.right);
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
        }
        return root;
    }

}