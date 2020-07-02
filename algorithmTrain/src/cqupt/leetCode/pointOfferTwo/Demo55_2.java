package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-02 10:24
 * 判断是否是平衡二叉树
 */
public class Demo55_2 {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalance;
    }

    private Res55 helper(TreeNode root) {
        if (root == null)
            return new Res55(0,true);
        Res55 left = helper(root.left);
        Res55 right = helper(root.right);
        Res55 res = new Res55(0,false);
        int leftHeight = left.height;
        int rightHeight = right.height;
        int rootHeight = Math.max(leftHeight,rightHeight) + 1;
        if (!left.isBalance || !right.isBalance) {
//            return new Res55(rootHeight, false);
            res.isBalance = false;
            res.height = rootHeight;
            return res;
        }
        if (Math.abs(leftHeight - rightHeight) <= 1) {
//            return new Res55(rootHeight, true);
            res.isBalance = true;
            res.height = rootHeight;
            return res;
        }
        return res;
//        return null;// 这个地方就算逻辑上返回什么都行,但是此方法返回值是Res55类型,就要定义一个默认的Res55
        // 就算为空时候也要返回一个Res55
    }
}
class Res55 {
    int height;
    boolean isBalance;

    public Res55(int height, boolean isBalance) {
        this.height = height;
        this.isBalance = isBalance;
    }
}
