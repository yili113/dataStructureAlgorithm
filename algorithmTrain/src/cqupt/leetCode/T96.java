package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-14 22:28
 * 不同的二叉搜索树
 * 动态规划
 * 一般要求返回个数或者返回有或者没有  考虑用动态规划
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
}
