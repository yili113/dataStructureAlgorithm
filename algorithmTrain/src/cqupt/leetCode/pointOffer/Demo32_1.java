package cqupt.leetCode.pointOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-06-01 14:27
 *
 */
public class Demo32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[]{};
        ArrayList<TreeNode> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                res.add(cur);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
           result[i] = res.get(i).val;
        }
        return result;
    }
}
