package cqupt.leetCode.pointOffer;

import java.util.*;

/**
 * @author yiLi
 * @create 2020-06-01 14:40
 */
public class Demo32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> curList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                curList.add(cur.val);
                if (cur.left != null)
                    queue.offer(cur.left);
                if (cur.right != null)
                    queue.offer(cur.right);
            }
            if (res.size() % 2 == 0) {// 已经放了偶数层,接下来奇数层
                res.add(curList);
            }else {
                ArrayList<Integer> reverse = new ArrayList<>();
                for (int i = curList.size(); i >= 0; i--) {
                    reverse.add(curList.get(i));
                }
                res.add(reverse);
            }
        }
        return res;
    }
}
