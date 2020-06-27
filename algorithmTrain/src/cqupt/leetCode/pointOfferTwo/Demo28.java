package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-27 9:23
 */
public class Demo28 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root, root);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (right == null || left == null) {
            return false;
        }
//        if (left.left.val != right.right.val || left.right.val != right.left.val)
//            return false;
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }
}


