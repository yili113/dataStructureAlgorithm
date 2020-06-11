package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-10 8:28
 */
public class Demo55_2 {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private ResType_55 helper(TreeNode root) {
        if (root == null)
            return new ResType_55(true, 0);
        ResType_55 res = new ResType_55(false, 0);
        ResType_55 left = helper(root.left);
        ResType_55 right = helper(root.right);
        // 判断子树是否平衡
        if (!left.isBalanced || !right.isBalanced)
            return res;
        // 此时子树是平衡的
        int leftHeight = left.height;
        int rightHeight = right.height;
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            res.isBalanced = true;
            res.height = Math.max(leftHeight, rightHeight) + 1;
            return res;
        }
        return res;
    }
}
class ResType_55 {
    boolean isBalanced;
    int height;

    public ResType_55(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }

    public ResType_55() {
    }
}
