package cqupt.leetCode.pointOfferThree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-07-25 13:56
 * 二叉树的层序遍历
 */
public class Demo32_1 {

    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[]{};
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
