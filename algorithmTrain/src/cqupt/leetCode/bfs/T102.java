package cqupt.leetCode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-18 16:48
 * 二叉树的层序遍历---bfs
 */
public class T102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        LinkedList<TreeNode> queue = new LinkedList<>();// 模拟存放结点的队列
        queue.addLast(root);
        ArrayList<Integer> cur_layer = null;// 存放每一层的结点
        while (!queue.isEmpty()) {
            int size = queue.size();// 记录每一层里面有多少个结点
            cur_layer = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.removeFirst();// 这里移出每一层的所有结点
                cur_layer.add(curNode.val);
                if (curNode.left != null)
                    queue.addLast(curNode.left);
                if (curNode.right != null)
                    queue.addLast(curNode.right);
            }
            result.add(cur_layer);// 把每一层的list放进结果集中
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
