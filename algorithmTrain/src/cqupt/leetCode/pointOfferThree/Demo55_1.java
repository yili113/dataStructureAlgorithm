package cqupt.leetCode.pointOfferThree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-08-04 16:56
 * 树的最大深度---迭代写法
 * 类似于层序遍历 记录每层结点的数量
 * 在同一层结点的子结点一起放进队列
 */
public class Demo55_1 {
    public int maxDepth(TreeNode root) {
        int res = 0;
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            res += 1;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
        }
        return res;
    }
}
