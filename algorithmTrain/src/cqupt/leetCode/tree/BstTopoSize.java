package cqupt.leetCode.tree;

/**
 * @author yiLi
 * @create 2020-05-21 19:21
 * 根据二叉树得到最大的满足二叉搜索树的拓扑结构
 * 最大是指结点是最多的
 */
public class BstTopoSize {
    // 1.返回最终的结点数
    // 最大的满足二叉搜索树的拓扑结构的结点数
    // 对每个结点都得到满足条件的结点数
    public int bstTopoSize(TreeNode root) {
        if (root == null)
            return 0;
        int max = maxTopSize(root, root);
        // 左右子树去查看
        max = Math.max(max, bstTopoSize(root.left));
        max = Math.max(max, bstTopoSize(root.right));
        return max;
    }
    // 2.从结点h出发得到最大的拓扑结构的结点数
    // 从根结点h去找 其下面的所有子结点的结点数
    private int maxTopSize(TreeNode root, TreeNode n) {
        if (root != null && n != null && isBstNode(root, n, n.val)) {
            // 此时就要去得到 n的左右子结点对于 root结点来说最大的结点数
            return maxTopSize(root, n.left) + maxTopSize(root, n.right) + 1;// +1是因为自身这个结点
        }
        return 0;
    }

    // 3.对于根结点h来说,判断结点n是否满足二叉搜索的条件
    // 传进来的val初始就是n的值
    private boolean isBstNode(TreeNode root, TreeNode n, int val) {
        if (root == n)
            return true;
        if (root == null)
            return false;
        return val >= root.val ? isBstNode(root.right, n, val) : isBstNode(root.left, n, val);
    }



}
