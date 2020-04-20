package cqupt.leetCode.dfs;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-04-17 10:57
 * 寻找二叉树的叶子结点
 */
public class T366_findBinaryTreeLeafNode {
    /**
     * 使用bfs层序反遍历是错误的
     * @param root
     * @return
     */
//    public List<List<Integer>> findLeaves1(TreeNode root) {
//        ArrayList<List<Integer>> resTemp = new ArrayList<>();
//        ArrayList<List<Integer>> res = new ArrayList<>();
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        if (root == null)
//            return res;
//        queue.addLast(root);// 先把root放进队列
//        while (!queue.isEmpty()) {
//            int cur_size = queue.size();
//            ArrayList<Integer> cur_res = new ArrayList<>();// 存放每一层的叶子结点
//            for (int i = 0; i < cur_size; i++) {
//                TreeNode curNode = queue.removeFirst();
//                cur_res.add(curNode.val);
//                // 判断左右子树
//                if (curNode.left != null)
//                    queue.addLast(curNode.left);
//                if (curNode.right != null)
//                    queue.addLast(curNode.right);
//            }
//            resTemp.add(cur_res);
//        }
//        for (int i = resTemp.size() - 1; i >= 0; i--) {
//            res.add(resTemp.get(i));
//        }
//        return res;
//    }

    /**
     * dfs
     * @param root
     * @return
     */
    public List<List<Integer>> findLeaves(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
//        while (root.left != null || root.right != null) {
//            helper(root, null, curList);
//            res.add(new ArrayList<>(curList));// 把每层的叶子结点放进res结果集
//            curList.clear();// 清空当前结果集方便下回用
//        }
//        curList.add(root.val);// 放入跟结点
//        res.add(new ArrayList<>(curList));


        hlper1(res, new ArrayList<Integer>(), root, null);
        return res;
    }

    /**
     *
     * @param res
     * @param curList 每层的叶子结点集合
     * @param root 当前结点
     * @param pre 上一结点
     */
    private void hlper1(ArrayList<List<Integer>> res, ArrayList<Integer> curList, TreeNode root, TreeNode pre) {
        if (root == null)
            return;
        // todo 将curList加入到res的条件是什么？

        // 1.root是叶子结点
        if (root.left == null && root.right == null) {
            curList.add(root.val);
            if (pre != null && pre.left == root)
                pre.left = null;
            if (pre != null && pre.right == root)
                pre.right = null;
        }
        // 2.root不是叶子结点

    }

    /**
     * 判断root结点是否是叶子结点,若是则利用pre结点删除root结点
     * @param root
     * @param pre
     * @param curList
     */
    private void helper(TreeNode root, TreeNode pre, ArrayList<Integer> curList) {
        if (root == null)
            return;
        // 判断root结点是否是叶子结点
        // 1.是叶子结点,进行添加叶子结点并且删除该叶子结点
        if (root.left == null && root.right == null) {
            curList.add(root.val);
            // 删除已经添加过的叶子结点
            if (pre != null && pre.left == root)
                pre.left = null;
            if (pre != null && pre.right == root)
                pre.right = null;
        }
        // 2.不是叶子结点,进行向下递推,找叶子结点
        pre = root;// 如果root不是叶子结点,则会向下递推
        helper(pre.left, pre, curList);
        helper(pre.right, pre, curList);
    }

    ArrayList<Integer> curList = new ArrayList<>();
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
