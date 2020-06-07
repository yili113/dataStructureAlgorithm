package cqupt.leetCode.pointOffer;

import java.util.ArrayList;

/**
 * @author yiLi
 * @create 2020-06-05 10:01
 */
public class Demo54 {
    private ArrayList<Integer> list;

    // 中序
    public int kthLargest1(TreeNode root, int k) {
        list = new ArrayList<>();
        if (root == null)
            return -1;
        helper(root);
        return list.get(list.size() - k);
    }

    private void helper(TreeNode root) {
        // 中序
        if (root.left != null)
            helper(root.left);
        list.add(root.val);
        if (root.right != null)
            helper(root.right);
    }


    // 前序遍历的倒序遍历,查找第k大结点
    private int k;
    private  int res;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        if (root == null)
            return -1;
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null)
            return;
        dfs(root.right);
        if (k == 0)
            return;
        if (--k == 0)// 这个就是下标的问题了
            res = root.val;
        dfs(root.left);
    }
}