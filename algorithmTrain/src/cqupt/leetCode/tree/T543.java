package cqupt.leetCode.tree;

/**
 * @author yiLi
 * @create 2020-05-20 20:21
 * 二叉树的直径
 */
public class T543 {
    int max = 0;
    // 对于某一个结点来说,经过该节点的最大长度是等于其左子树高度+其右子树高度
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root.left == null && root.right == null)
            return 0;
        int leftDepth = root.left == null ? 0 : dfs(root.left) + 1;
        int rightDepth = root.right == null ? 0: dfs(root.right) + 1;
        max = Math.max(leftDepth + rightDepth, max);
        return Math.max(leftDepth, rightDepth);
    }
}
class resType543 {
    int depth;

    public resType543(int maxLen) {
        this.depth = 0;
    }
}
