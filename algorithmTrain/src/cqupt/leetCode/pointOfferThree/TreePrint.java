package cqupt.leetCode.pointOfferThree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-07-21 19:18
 * 二叉树的前中后序遍历
 */
public class TreePrint {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(root, "white"));
        while (!stack.isEmpty()) {
            ColorNode cur = stack.pop();
            if (cur.color.equals("white")) {
                // 前中后序遍历只需改变white结点放入stack的顺序
                stack.push(new ColorNode(cur.node, "gray"));
                if (cur.node.right != null) {
                    stack.push(new ColorNode(cur.node.right, "white"));
                }
                if (cur.node.left != null) {
                    stack.push(new ColorNode(cur.node.left, "white"));
                }
            }else {
                res.add(cur.node.val);
            }
        }
        return res;
    }
}

class ColorNode {
    TreeNode node;
    String color;

    public ColorNode(TreeNode node, String color) {
        this.node = node;
        this.color = color;
    }
}
