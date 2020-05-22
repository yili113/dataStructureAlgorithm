package cqupt.leetCode.tree;

import java.util.LinkedList;

/**
 * @author yiLi
 * @create 2020-05-21 9:41
 */
public class SerialTree {

    public String serialByPre(TreeNode root) {
        if (root == null)
            return "#!";
        String str = root.val + "!";
        str += serialByPre(root.left);
        str += serialByPre(root.right);
        return str;
    }
    public TreeNode reconByPreString(String preStr) {
        String[] strings = preStr.split("!");
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            queue.offer(strings[i]);
        }
        TreeNode head = recon(queue);
        return head;
    }

    private TreeNode recon(LinkedList<String> queue) {
        String cur = queue.poll();
        if (cur.equals("#"))
            return null;
        TreeNode head = new TreeNode(Integer.parseInt(cur));
        head.left = recon(queue);
        head.right = recon(queue);
        return head;
    }
    public String serialByLevel(TreeNode root) {
        if (root == null)
            return "#!";
        LinkedList<TreeNode> queue = new LinkedList<>();
        String str = root.val + "!";
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                str = str + cur.left.val + "!";
                queue.offer(root.left);
            }else
                str += "#!";
            if (cur.right != null) {
                str += cur.right.val + "!";
                queue.offer(root.right);
            }else
                str += "#!";
        }
        return str;
    }
}
