package cqupt.leetCode.tree;

/**
 * @author yiLi
 * @create 2020-05-21 16:47
 */
public class MaxSearchTree {
    public TreeNode process(TreeNode root) {
        return helper(root).maxHead;
    }
    public ResType111 helper(TreeNode root) {
        if (root == null)
            return new ResType111(null, 0, Integer.MIN_VALUE,
                    Integer.MAX_VALUE);
        // 默认左右子树的都能拿到
        ResType111 leftRes = helper(root.left);
        ResType111 rightRes = helper(root.right);
        // 收集左右子树的信息 先考虑最终结果只在左子树或者右子树中
        int max = Math.max(leftRes.max, rightRes.max);
        int min = Math.min(leftRes.min, rightRes.min);
        int maxSize = Math.max(leftRes.maxSize, rightRes.maxSize);
        TreeNode maxHead = leftRes.maxSize > rightRes.maxSize ? leftRes.maxHead : rightRes.maxHead;
        // 判断能否将当前结点加进去构成大的二叉搜索
        if (root.val > leftRes.max && root.val < rightRes.min && root.left == leftRes.maxHead
            && root.right == rightRes.maxHead) {
            // 融合当前结点的信息与左右子树信息构成更大的二叉搜索树
            maxSize = leftRes.maxSize + rightRes.maxSize + 1;
            maxHead = root;
            max = Math.max(max, root.val);
            min = Math.min(min, root.val);
        }
        return new ResType111(maxHead, maxSize, max, min);
    }
}
class ResType111 {
    TreeNode maxHead;// 二叉搜索树中的最大结点
    int maxSize;// 二叉树中的最大结点数
    int max;// 结点中的最大值
    int min;// 结点中的最小值

    public ResType111(TreeNode maxHead, int maxSize, int max, int min) {
        this.maxHead = maxHead;
        this.maxSize = maxSize;
        this.max = max;
        this.min = min;
    }
}
