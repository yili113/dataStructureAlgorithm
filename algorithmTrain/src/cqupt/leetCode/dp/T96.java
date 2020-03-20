package cqupt.leetCode.dp;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-14 22:28
 * 不同的二叉搜索树
 * 动态规划
 * 一般要求返回个数或者返回有或者没有  考虑用动态规划
 * 动态规划没有办法求详细的解
 */
public class T96 {

    /**
     * 当n个结点时候 除去根结点还剩n-1个结点可以支配
     * 左子树有0个结点，右子树就是n-1个结点.....左子树k个结点，右子树就是n-1-k个结点(k=0...n-1)
     *
     * 当左子树k个结点，右子树n-1-k个结点时候，左子树就是dp[k]种情况，右子树dp[n-1-k]种情况
     * 那么一共就是乘积关系  dp[k]*dp[n-1-k]种情况
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];// dp[n]表示n个结点时有多少种
        // 初始化
        dp[0] = 1;// 初始化0位置时是反推的  dp[2]=2
        dp[1] = 1;
        for (int i = 2; i <= n ; i++) {
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += dp[j] * dp[i - j - 1];
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    /**
     *
     * @param n 结点数
     * @return 不同二叉搜索树的结果集   详细解---递归
     */
    public List<TreeNode> generateTrees(int n) {
        /**
         * 在这里定义result作为参数传进去 在遍历左子树和右子树时候会造成并发修改异常
         * 应该把result定义在helper函数内
         */
//        ArrayList<TreeNode> result = new ArrayList<>();
//        return helper(result, 1, n);
        return helper(1, n);
    }

    /**
     * 对于某一结点k来说,其左子树结点范围是1--(k-1),右子树结点范围是(k+1)--n
     * @param min
     * @param max
     */
    private List<TreeNode> helper(int min, int max) {
        ArrayList<TreeNode> result = new ArrayList<>();
        // 递归出口--min>max
        if (min > max)
            return result;
        // 左右子树分别遍历
        // 当前方法内所有可能值都尝试作为 root
        for (int root = min; root <= max ; root++) {
            // 得到左右子树结点集合
            List<TreeNode> leftList = helper(min, root - 1);
            List<TreeNode> rightList = helper(root + 1, max);
            TreeNode rootNode;
            // 判断左右子树集合情况
            if (leftList.size() == 0 && rightList.size() == 0) {
                rootNode = new TreeNode(root);
                result.add(rootNode);
            }
            else if (rightList.size() == 0) {
                for(TreeNode leftNode : leftList) {
                    // 将结点拼接成树
                    rootNode = new TreeNode(root);
                    rootNode.left = leftNode;
                    result.add(rootNode);
                }
            }
            else if (leftList.size() == 0) {
                for(TreeNode rightNode : rightList) {
                    rootNode = new TreeNode(root);
                    rootNode.right = rightNode;
                    result.add(rootNode);
                }
            }
            else {
                for(TreeNode leftNode : leftList) {
                    for (TreeNode rightNode : rightList) {
                        rootNode = new TreeNode(root);
                        rootNode.right = rightNode;
                        rootNode.left = leftNode;
                        result.add(rootNode);
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

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