package cqupt.leetCode.pointOffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-06-01 16:05
 */
public class Demo34_impor {
    private ArrayList<List<Integer>> res = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        ArrayList<List<Integer>> res = new ArrayList<>();
//        if (root == null)
//            return res;
//        helper(root, res, new ArrayList<Integer>(), sum);
//        return res;
        recur1(root, sum);
        return res;
    }

    private void recur1(TreeNode root, int sum) {
        if (root == null)
            return;
        sum -= root.val;
        path.add(root.val);
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new LinkedList<>(path));
        }
        recur1(root.left, sum);
        recur1(root.right, sum);
        path.removeLast();
    }

    private void helper(TreeNode root, ArrayList<List<Integer>> res, ArrayList<Integer> curList, int sum) {
        if (root == null)
            return;
        if (sum == 0) {
            res.add(new ArrayList<>(curList));
            return;
        }
        if (root.val <= sum)
            curList.add(root.val);
        helper(root.left, res, curList, sum - root.val);
        helper(root.right, res,curList,sum - root.val);
        curList.remove(curList.size() - 1);
    }
    private void recur(TreeNode root, int sum, ArrayList<List<Integer>> res, ArrayList<Integer> curList) {
        if (root == null)
            return;
        if (sum == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(curList));
            return;
        }
        curList.add(root.val);
        sum -= root.val;
        recur(root.left, sum, res, curList);
        recur(root.right, sum, res, curList);
        curList.remove(curList.size() - 1);
    }
}
