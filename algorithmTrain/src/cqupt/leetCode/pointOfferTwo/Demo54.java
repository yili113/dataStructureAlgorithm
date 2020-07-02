package cqupt.leetCode.pointOfferTwo;



/**
 * @author yiLi
 * @create 2020-07-02 10:08
 * 二叉搜索树的第k大结点
 */
public class Demo54 {
    // 输入: root = [5,3,6,2,4,null,null,1], k = 3
    // 输出 4
    private int COUNT;
    private int RES;
    public int kthLargest1(TreeNode root, int k) {
        // 找二叉搜索树的k大结点 就是按照  右-中-左  遍历
        COUNT = 0;
        RES = 0;
        dfs(root, k);
        return RES;
    }

    private void dfs(TreeNode root, int k) {
        if (root.right != null)
            dfs(root.right, k);
        if (COUNT == k)
            RES = root.val;
        COUNT ++;
        if (root.left != null)
            dfs(root.left,k);
    }

}
