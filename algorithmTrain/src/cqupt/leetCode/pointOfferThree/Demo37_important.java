package cqupt.leetCode.pointOfferThree;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-07-25 15:06
 * 序列化二叉树
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]
 */
public class Demo37_important {
    public String serialize(TreeNode root) {
        if (root == null)
            return "null" + ",";
        String str = root.val + ",";
        str += serialize(root.left);
        str += serialize(root.right);
        return str;
    }

    // 反序列化时候 用index不易实现
    public TreeNode deserialize1(String data) {
        String[] strs = data.split(",");
        return helper1(strs, 0);
    }

    private TreeNode helper1(String[] strs, int index) {
        if (strs[index].equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(strs[index]));
        root.left = helper1(strs, index + 1);
        root.right = helper1(strs, index + 2);
        return root;
    }

    // 队列易实现每个结点的左右子结点创建
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, strs);
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        String curStr = queue.poll();
        if (curStr.equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(curStr));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }
}
