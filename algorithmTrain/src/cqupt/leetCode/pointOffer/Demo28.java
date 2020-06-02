package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-01 9:34
 * 对称的二叉树
 */
public class Demo28 {
    // 每次调用递归函数能判断一对结点是否对称,最多调用N/2次递归
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return helper(root, root);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if ((left == null && right != null) || (left != null && right == null))
            return false;
        // 到这里就说明left和right都是有值的,就需要比较二者值是否相等,并且递归比较left的子树和right子树情况
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }
}
