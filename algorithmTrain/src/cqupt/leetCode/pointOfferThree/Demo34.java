package cqupt.leetCode.pointOfferThree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-07-25 14:17
 * 二叉树中和为某一值的路径
 * 从根结点到叶子结点才算一条路径
 * sum=22
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *    [5,4,11,2],
 *    [5,8,4,5]
 */
public class Demo34 {
    private List<List<Integer>> RES;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        RES = new ArrayList<>();
        if (root == null)
            return RES;
        helper(root, sum, new ArrayList<Integer>());
        return RES;
    }

    private void helper(TreeNode root, int sum, ArrayList<Integer> curList) {
        if (root == null)
            return;

        curList.add(root.val);
        sum -= root.val;

        if (sum == 0 && root.left == null && root.right == null) {
            RES.add(new ArrayList<>(curList));
        }

        helper(root.left, sum, curList);
        helper(root.right, sum, curList);

        curList.remove(curList.size() - 1);
        sum += root.val;
    }
}
