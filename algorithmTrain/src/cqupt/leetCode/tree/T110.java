package cqupt.leetCode.tree;

/**
 * @author Liyi
 * @create 2020-03-19 15:17
 * 判断平衡树---分治
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class T110 {
    public boolean isBalanced(TreeNode root) {
        return helper(root).isBalanced;
    }

    private ResultType helper(TreeNode root) {
        ResultType rt = new ResultType();
        if (root == null) {
            rt.isBalanced = true;
            return rt;
        }
        ResultType left = helper(root.left);// 上面判断了为空的情况,此时就不需要判断左右子树是否为空,就算为空进入下层也会有操作
        ResultType right = helper(root.right);
        rt.depth = Math.max(left.depth, right.depth) + 1;
        if (!left.isBalanced || !right.isBalanced) {// 左右子树只要有一个不是平衡的就返回false
            rt.isBalanced = false;
            return rt;
        }
        if (Math.abs(left.depth - right.depth) <= 1)// 此时左右子树分别都是平衡的,现在需要判断左右子树结合到一起是否平衡
            rt.isBalanced = true;
        else
            rt.isBalanced = false;
        return rt;
    }
}
class ResultType {
    int depth;
    boolean isBalanced;

    public ResultType() {
        this.depth = 0;
        this.isBalanced = false;
    }
}
