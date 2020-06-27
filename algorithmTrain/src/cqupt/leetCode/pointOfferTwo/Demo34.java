package cqupt.leetCode.pointOfferTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-06-27 15:20
 * 二叉树中和为某值的路径
 */
public class Demo34 {
    // 路径时必须到叶子结点的
    ArrayList<List<Integer>> RES;
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
        sum -= root.val;
        curList.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            RES.add(new ArrayList<>(curList));
            return;
        }
        helper(root.left, sum, curList);
        helper(root.right, sum, curList);
        sum += root.val;
        curList.remove(curList.size() - 1);
    }
}
