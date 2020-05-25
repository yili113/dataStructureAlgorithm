package cqupt.leetCode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-05-24 15:59
 */
public class NumTrees {


    public static int numTrees(int N) {
        if (N < 2)
            return 1;
        int[] dp = new int[N +1];
        dp[0] = 1;
        for (int i = 1; i < N + 1; i++) {// 总共的结点数 从 1---N
            for (int j = 0; j < i; j++) {// 左子树节点个数从 0开始增加
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

    public List<TreeNode> generateTrees(int N) {
        if (N < 1)
            return new ArrayList<>();
        return generate(1, N);
    }

    private List<TreeNode> generate(int start, int end) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
        }
        for (int i = start; i < end + 1; i++) {
            TreeNode head = new TreeNode(i);
            // 产生左
            List<TreeNode> leftList = generate(start, i - 1);
            // 产生右
            List<TreeNode> rightList = generate(i + 1, end);
            for(TreeNode l : leftList) {
                for(TreeNode r : rightList) {
                    head.left = l;
                    head.right = r;
                    TreeNode cur = cloneTree(head);
                    res.add(cur);
                }
            }
        }
        return res;
    }

    private TreeNode cloneTree(TreeNode head) {
        if (head == null)
            return null;
        TreeNode res = new TreeNode(head.val);
        res.left = cloneTree(head.left);
        res.right = cloneTree(head.right);
        return res;
    }
}
