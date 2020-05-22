package cqupt.leetCode.tree;

/**
 * @author yiLi
 * @create 2020-05-21 9:30
 */
public class PrintTree {
    public void printTree(TreeNode root) {

        dfs(root, 0, "H", 17);
        System.out.println();
    }

    private void dfs(TreeNode root, int height, String to, int len) {
        if (root == null)
            return;
        // 因为是旋转90度直观打印 所以是先打印右子树
        dfs(root.right, height + 1, "v", len);
        String val = to + root.val + to;
        System.out.println(val);
        dfs(root.left, height + 1, "^", len);
    }
}
