package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-31 15:19
 * 包含子树
 */
public class Demo26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null)
            return false;
        return check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean check(TreeNode a, TreeNode b) {
        if (b == null)
            return true;
        if (a == null || a.val != b.val) {
            return false;
        }
        return check(a.left, b.left) && check(a.right, b.right);
    }
}
