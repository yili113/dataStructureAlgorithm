package cqupt.leetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-05-21 19:48
 * 层序遍历打印
 * 每一层的在同一行打印
 */
public class PrintLevel {
    public void print(TreeNode root) {
        if (root == null)
            return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            // 判断每一层有多少个结点
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.println(cur.val);
                if (root.left != null)
                    queue.offer(root.left);
                if (root.right != null)
                    queue.offer(root.right);
            }
            System.out.println();
        }
    }
}
