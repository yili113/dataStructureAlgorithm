package cqupt.leetCode.pointOfferTwo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-06-28 9:23
 */
public class Demo37 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // 通过前序遍历进行序列化
        if (root == null)
            return "null,";
        String str = root.val + ",";// 当前结点
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strs.length; i++) {
            queue.offer(strs[i]);
        }
        TreeNode head = recur(queue);
        return head;
    }

    private TreeNode recur(Queue<String> queue) {
        String curStr = queue.poll();
        if (curStr.equals("null"))
            return null;
        TreeNode head = new TreeNode(Integer.parseInt(curStr));
        head.left = recur(queue);
        head.right = recur(queue);
        return head;
    }
}
