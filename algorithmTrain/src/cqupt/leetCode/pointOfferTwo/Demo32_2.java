package cqupt.leetCode.pointOfferTwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-06-27 10:54
 */
public class Demo32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> curList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.removeFirst();
                curList.add(curNode.val);
                if (curNode.left != null)
                    queue.addLast(curNode.left);
                if (curNode.right != null)
                    queue.addLast(curNode.right);
            }
            res.add(curList);
        }
        return res;
    }
}
