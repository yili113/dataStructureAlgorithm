package cqupt.leetCode.pointOfferTwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-06-27 10:48
 */
public class Demo32_1 {
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[]{};
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
