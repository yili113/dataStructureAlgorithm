package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-08-04 17:03
 */
public class Demo55_2 {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalance;
    }

    private Res55 helper(TreeNode root) {
        Res55 res = new Res55();
        if (root == null) {
            res.height = 0;
            res.isBalance = true;
            return res;
        }
        Res55 left = helper(root.left);
        Res55 right = helper(root.right);
        if (!left.isBalance || !right.isBalance) {
            res.isBalance = false;
            return res;
        }
        int leftHeight = left.height;
        int rightHeight = right.height;
        if (Math.abs(leftHeight - rightHeight) <= 1) {
            res.isBalance = true;
            res.height = Math.max(leftHeight, rightHeight) + 1;
            return res;
        }else {
            res.isBalance = false;
            res.height = Math.max(leftHeight, rightHeight) + 1;
            return res;
        }
    }
}

class Res55 {
    int height;
    boolean isBalance;
}
