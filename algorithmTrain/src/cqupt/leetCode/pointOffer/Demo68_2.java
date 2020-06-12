package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-12 16:11
 */
public class Demo68_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q).lcd;
    }

    private ResultType68_2 helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return new ResultType68_2();
        ResultType68_2 res = new ResultType68_2();
        ResultType68_2 left = helper(root.left, p, q);
        ResultType68_2 right = helper(root.right, p, q);
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
        if (res.hasQ && res.hasP)
            res.lcd = root;
        return res;
    }
}
class ResultType68_2 {
    boolean hasP;
    boolean hasQ;
    TreeNode lcd;
}
