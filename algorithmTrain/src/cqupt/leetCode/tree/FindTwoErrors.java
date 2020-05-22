package cqupt.leetCode.tree;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-05-21 20:17
 */
public class FindTwoErrors {
    public TreeNode[] getTwoErrNodes(TreeNode head) {
        TreeNode[] errors = new TreeNode[2];
        if (head == null)
            return errors;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (pre != null && pre.val > cur.val) {
                // 第一个位置只有在第一次出现递减时候才会赋值  errors[0]一定是被赋值成pre  大的那个值
                errors[0] = errors[0] == null ? pre : errors[0];
                // 第二个位置在第一次和第二次时候都会被赋值,如果有第二次递减赋值就会覆盖第一次的
                // 且一定是赋值那个小的值
                errors[1] = cur;
            }
            pre = cur;
            cur = cur.right;
        }
        return errors;
    }
}
