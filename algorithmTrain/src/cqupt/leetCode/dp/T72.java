package cqupt.leetCode.dp;

/**
 * @author Liyi
 * @create 2020-04-06 10:03
 * 编辑距离
 *      " "  r   o   s
 *  " " 0   1   2   3
 *  h   1   1   2   3
 *  o   2   2   1
 *  r   3
 *  s   4
 *  e   5
 *  对于上述例子来讲：
 *  横走向表示增加字母的最小次数
 *  纵走向表示删除字母的最小次数
 *  对角巷走向表示替换字母的最小次数
 *  dp[i][j]--->word1中前i个字母变到word2中的前j个字母需要的最小次数
 */
public class T72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 1.初始化
        for (int i = 1; i < m + 1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int j = 1; j < n + 1; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        // 2.状态方程
        for (int i = 1; i < m + 1; i++) {// 遍历行
            for (int j = 1; j < n + 1; j++) {// 遍历列
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        // 3.返回结果
        return dp[m][n];
    }
}
