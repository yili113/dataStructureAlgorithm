package cqupt.leetCode.pointOffer;

import java.util.LinkedList;

/**
 * @author yiLi
 * @create 2020-06-02 9:12
 */
public class Demo37_impor {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 前序遍历序列化二叉树
        if (root == null)
            return "null,";
        String res = root.val + ",";
        // 不用判断左右子树是否为空
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            queue.offer(strs[i]);
        }
        TreeNode head = recon(queue);
        return head;
    }

    private TreeNode recon(LinkedList<String> queue) {
        String cur = queue.poll();
        if (cur.equals("null"))
            return null;
        TreeNode head = new TreeNode(Integer.parseInt(cur));
        head.left = recon(queue);
        head.right = recon(queue);
        return head;
    }
}
