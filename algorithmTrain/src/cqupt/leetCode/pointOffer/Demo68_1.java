package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-13 12:12
 */
public class Demo68_1 {
    // 迭代
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        while (root != null) {
            if (root.val < p.val && root.val < q.val)// p q都在root的右子树侧
                root = root.right;
            else if (root.val > p.val && root.val > q.val)
                root = root.left;
            else
                break;// 这种情况就是p q分居root左右子树两侧
        }
        return root;
    }
    // 递归
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root.val < p.val && root.val < q.val)
            root = lowestCommonAncestor(root.right, p, q);
        if (root.val > p.val && root.val > q.val)
            root = lowestCommonAncestor(root.left,p,q);
        return root;
    }
}