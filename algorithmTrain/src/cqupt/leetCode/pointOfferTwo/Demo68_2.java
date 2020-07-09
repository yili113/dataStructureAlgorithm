package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-09 20:46
 */
public class Demo68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q).lcd;
    }

    private Res68 helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return new Res68();
        Res68 res = new Res68();
        Res68 left = helper(root.left, p, q);
        Res68 right = helper(root.right, p, q);
        if (left.lcd != null)
            return left;
        if (right.lcd != null)
            return right;
        if (root == p || left.hasP || right.hasP)
            res.hasP = true;
        if (root == q || left.hasQ || right.hasQ)
            res.hasQ = true;
        if (res.hasP && res.hasQ)
            res.lcd = root;
        return res;
    }
}
class Res68 {
    TreeNode lcd;
    boolean hasP;
    boolean hasQ;
}
