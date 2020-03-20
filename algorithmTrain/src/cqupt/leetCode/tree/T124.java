package cqupt.leetCode.tree;

/**
 * @author Liyi
 * @create 2020-03-20 8:42
 * 二叉树中的最大路径和
 */
public class T124 {
    public int maxPathSum(TreeNode root) {
        return helper(root).maxSum;
    }

    private ResType124 helper(TreeNode root) {
        ResType124 res = new ResType124();// 每一层的root对应每一层的res对象
        if (root == null)
            return res;// 此时的res就是初始的最小值
        ResType124 left = helper(root.left);
        ResType124 right = helper(root.right);
        // res中的pathSum表示经过当前的结点root能提供的最大的路径和,root下面有两条路,不可能把两条路都算上
        // 只能选取最大的一条路,在加上root结点本身的val.就构成了当前结点root能提供给别的结点的最大路径和
        res.pathSum = Math.max(Math.max(left.pathSum, right.pathSum), 0) + root.val;
        // curSum表示假设就以当前结点root作为最终的转弯结点(结点A到结点B肯定需要有个岔路口结点)
        // curSum就等于左子结点能提供的最大路径和+右子结点能提供的最大路径和+当前结点本身的值
        // 但是左子结点或右子结点不能提供负值
        // curSum用于更新maxSum
        int curSum = Math.max(left.pathSum, 0) + Math.max(right.pathSum, 0) + root.val;
        // maxSum为 左侧最大、右侧最大、包含当前的最大  中最大的一个
        res.maxSum = Math.max(Math.max(left.maxSum, right.maxSum), curSum);
        return res;
    }
}
class ResType124 {
    int maxSum = Integer.MIN_VALUE;// 最终需要返回的总体的最大值
    int pathSum = Integer.MIN_VALUE;// 如果当前结点A要加到别的结点中计算路径和,这个pathSum就是结点A能提供的经过A的路径和
}
