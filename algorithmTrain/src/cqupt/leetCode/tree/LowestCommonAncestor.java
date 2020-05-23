package cqupt.leetCode.tree;

/**
 * @author yiLi
 * @create 2020-05-23 15:45
 */
public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q).lcd;
    }

    private ResLowestCommonAncestor helper(TreeNode root, TreeNode p, TreeNode q) {
        ResLowestCommonAncestor res = new ResLowestCommonAncestor();
        if (root == null)
            return res;
        ResLowestCommonAncestor left = helper(root.left, p, q);
        ResLowestCommonAncestor right = helper(root.right, p, q);
        if (left.lcd != null) {
            res.lcd = left.lcd;
            return res;
        }
        if (right.lcd != null) {
            res.lcd = right.lcd;
            return res;
        }
        if (root == p || left.hasP || right.hasP)
            res.hasP = true;
        if (root == q || left.hasQ || right.hasQ)
            res.hasQ = true;
        if (res.hasP && res.hasQ) {
            res.lcd = root;
        }
        return res;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null)
            return root;
        if (left != null)
            return left;
        if (right != null)
            return right;
        return null;
    }
}
class ResLowestCommonAncestor {
    boolean hasP;
    boolean hasQ;
    TreeNode lcd;

}