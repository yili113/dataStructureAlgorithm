package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-24 13:23
 * 判断树的子结构
 */
public class Demo26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null)
            return false;
        if (B == null)
            return false;
        return check(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean check(TreeNode A, TreeNode B) {
        // 下面这两个判断不能写反了
        // 在B!=null的情况下A=null才是false
        if (B == null)
            return true;
        if (A == null) {
            return false;
        }
        return A.val == B.val && check(A.left, B.left) && check(A.right, B.right);
    }
}
