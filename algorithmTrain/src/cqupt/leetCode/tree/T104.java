package cqupt.leetCode.tree;



/**
 * @author Liyi
 * @create 2020-03-19 15:06
 * 树的最大深度---分治
 */
public class T104 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int left = 0;
        int right = 0;
        if (root.left != null) {// 此处不用判断是否为空
            left = maxDepth(root.left);
        }
        if (root.right != null)
            right = maxDepth(root.right);
        return Math.max(left, right) + 1;
        /**
         * 很简单的就是一个结点的高度肯定其左子树的高度和右子树高度的最大值再+1
         * 这个+1是算山自身这个结点
         * 如果一个结点没有左右子树 其高度就是0+1=1
         */
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
