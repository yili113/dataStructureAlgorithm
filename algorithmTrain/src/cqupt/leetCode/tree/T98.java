package cqupt.leetCode.tree;

/**
 * @author Liyi
 * @create 2020-03-20 9:31
 * 验证二叉搜索树---分治
 */
public class T98 {
    public boolean isValidBST(TreeNode root) {
        return helper(root).isValid;
    }

    private ResType98 helper(TreeNode root) {
        ResType98 res = new ResType98();
        if (root == null) {
            res.isValid = true;// 一般来说null结点的bool类型的都是true
            return res;
        }
        ResType98 left = helper(root.left);
        ResType98 right = helper(root.right);
        if (!left.isValid || !right.isValid) {
            res.isValid = false;
            return res;
        }
        // 到这一步就说明左右子树都是有效的
        // 再需要判断当前结点root加进去之后还是否有效
        if (left.maxVal < root.val && right.minVal > root.val) {// 左子树的最大结点小于当前结点,右子树的最小结点大于当前结点
            // 说明当前结点可以加进去
            // 更新当前结点的属性
            res.maxVal = Math.max(right.maxVal, root.val);
            res.minVal = Math.min(left.minVal, root.val);
            res.isValid = true;
            return res;
        }else {
            res.isValid = false;
            return res;
        }
    }
}
class ResType98 {
    boolean isValid = false;
    long maxVal = Long.MIN_VALUE;
    long minVal = Long.MAX_VALUE;
}
