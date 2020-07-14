package cqupt.leetCode.pointOfferTwo.houseRobber;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-07-13 13:30
 */
public class Demo3 {
    // 二叉树结构 相连的结点不能一起抢
    // 如果当前结点没抢,那么其左右子结点都能抢
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        // 抢当前结点
        int yes = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        // 不抢当前结点,就可以把当前结点的左右子结点都能抢
        int no = rob(root.left) + rob(root.right);
        int rootVal = Math.max(yes,no);
        memo.put(root, rootVal);
        return rootVal;
    }
    HashMap<TreeNode, Integer> memo = new HashMap<>();


    public int rob1(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);// [0]表示不抢 [1]表示抢
    }

    private int[] helper(TreeNode root) {
        if (root == null)
            return new int[]{0, 0};
        int[] leftArr = helper(root.left);
        int[] rightArr = helper(root.right);
        // 抢当前结点,其子结点就不能抢了
        int yes = root.val + leftArr[0] + rightArr[0];
        // 不抢当前结点,其子结点可以抢,此时两个子结点可以都抢,也可以只抢其一
//        int no = Math.max(Math.max(leftArr[1] + rightArr[0], leftArr[0] + rightArr[1]),
//                leftArr[1] + rightArr[1]);
        int no = Math.max(leftArr[0], leftArr[1]) + Math.max(rightArr[0], rightArr[1]);
        return new int[]{no, yes};// 这个地方不能写反了,0下标是不抢
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
