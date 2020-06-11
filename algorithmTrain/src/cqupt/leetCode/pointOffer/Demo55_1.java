package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-07 9:51
 */
public class Demo55_1 {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
