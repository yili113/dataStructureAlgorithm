package cqupt.leetCode.tree;

/**
 * @author yiLi
 * @create 2020-05-20 21:09
 * 判断平衡式
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private TypeIsBalanced helper(TreeNode root) {
        if (root == null)
            return new TypeIsBalanced(0, true);
        TypeIsBalanced leftType = helper(root.left);
        TypeIsBalanced rightType = helper(root.right);
        int height = Math.max(leftType.height, rightType.height) + 1;
        boolean isBalanced = leftType.isBalanced && rightType.isBalanced && Math.abs(leftType.height - rightType.height)
        < 2;
        return new TypeIsBalanced(height, isBalanced);
    }
}
class TypeIsBalanced {
    int height;
    boolean isBalanced;

    public TypeIsBalanced(int height, boolean isBalanced) {
        this.height = height;
        this.isBalanced = isBalanced;
    }
}
