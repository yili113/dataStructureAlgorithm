package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-26 16:02
 * 判断B是否是A的子结构
 */
public class Demo26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B == null)
            return false;
        if (A == null)
            return false;
        return check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean check(TreeNode A, TreeNode B) {
        if (B == null)
            return true;
        if (A == null)
            return false;
        return A.val == B.val && check(A.left, B.left) && check(A.right, B.right);
    }
}
