package cqupt.leetCode.pointOfferTwo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-06-28 9:51
 * 层序遍历序列化与反序列化
 */
public class Demo37_2 {
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null)
            return "null,";
        queue.offer(root);
        String str = root.val + ",";
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                str += cur.left.val + ",";
                queue.offer(cur.left);
            }else
                str += "null,";
            if (cur.right != null) {
                str += cur.right.val + ",";
                queue.offer(cur.right);
            }else
                str += "null,";
        }
        return str;
    }
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        int index = 0;
        TreeNode head = generate(strs[index ++]);
        Queue<TreeNode> deQueue = new LinkedList<>();
        if (head != null )
            deQueue.offer(head);
        TreeNode dummy = null;
        while (!deQueue.isEmpty()) {
            dummy = deQueue.poll();
            dummy.left = generate(strs[index ++]);
            dummy.right = generate(strs[index ++]);
            if (dummy.left != null)
                deQueue.offer(dummy.left);
            if (dummy.right != null)
                deQueue.offer(dummy.right);
        }
        return head;
    }

    private TreeNode generate(String str) {
        if (str.equals("null"))
            return null;
        return new TreeNode(Integer.parseInt(str));
    }
}
