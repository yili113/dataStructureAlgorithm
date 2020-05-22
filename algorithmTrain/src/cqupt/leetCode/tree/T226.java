package cqupt.leetCode.tree;

/**
 * @author yiLi
 * @create 2020-05-20 20:50
 */
public class T226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;
        return root;
    }
}
