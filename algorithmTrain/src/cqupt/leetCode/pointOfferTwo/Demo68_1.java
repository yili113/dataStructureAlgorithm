package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-09 21:16
 * 二叉平衡树的最近公共祖先
 */
public class Demo68_1 {
    // 迭代
    // 符合一个规律：
    // 只要p q在root结点的两侧  就说明root是p q 的最近公共祖先
    // 只要p q在root的同侧,就迭代root
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val < p.val && root.val < q.val)
                root = root.right;
            else if (root.val > p.val && root.val > q.val)
                root = root.left;
            else
                break;
        }
        return root;
    }
    // 递归
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor2(root.right,p,q);
        else if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor2(root.left,p,q);
        else
            return root;
    }
}
