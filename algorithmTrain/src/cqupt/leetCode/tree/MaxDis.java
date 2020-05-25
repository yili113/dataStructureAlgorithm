package cqupt.leetCode.tree;

/**
 * @author yiLi
 * @create 2020-05-24 10:40
 * 二叉树结点间的最大距离
 * 对于当前结点来讲 经过当前结点构成的最大距离 一共分以下几种情况
 * 1.加上当前结点就不能更新最大距离,此时就是 要么是左子树的最大距离 要么是右子树的最大距离
 * 2.加上当前节点能够更新最大距离,此时就是 左子树的高度+右子树的高度+当前节点
 */
public class MaxDis {

    public int process(TreeNode root) {
        return helper(root).maxLen;
    }

    private ResMaxDis helper(TreeNode root) {
        ResMaxDis res = new ResMaxDis(0, 0);
        if (root == null)
            return res;
        ResMaxDis left = helper(root.left);
        ResMaxDis right = helper(root.right);
        int leftHeight = left.height;
        int rightHeight = right.height;
        int leftMaxLen = left.maxLen;
        int rightMaxLen = right.maxLen;
        int maxLen = Math.max(Math.max(leftMaxLen, rightMaxLen), leftHeight + rightHeight + 1);
        int height = Math.max(leftHeight, rightHeight) + 1;
        res.maxLen = maxLen;
        res.height = height;
        return res;
    }
}
class ResMaxDis {
    int maxLen;// 经过当前结点的最大距离
    int height;// 每个结点的高度

    public ResMaxDis(int maxLen, int height) {
        this.maxLen = maxLen;
        this.height = height;
    }
}
