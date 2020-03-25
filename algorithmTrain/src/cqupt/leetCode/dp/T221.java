package cqupt.leetCode.dp;

/**
 * @author Liyi
 * @create 2020-03-25 14:16
 * 最大正方形---dp
 * 考虑(i,j)位置为正方形右下角的最大正方形其实是取(i-1,j),(i,j-1),(i-1,j-1)三个位置为正方形右下角中最小的那个
 * 然后+1,表示(i,j)为右下角时最大正方形的边长
 */
public class T221 {

    public static int maximalSquare(char[][] matrix) {
        int maxLen = 0;
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxLen * maxLen;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        // 初始化
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == '1') {// 边界上单独的一个数为1的话就表示以该位置作为正方形右下角构成最大最大正方形边长为1
                dp[i][0] = 1;
                maxLen = 1;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                maxLen = 1;
            }
        }
        // 状态方程迭代
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }
        return maxLen * maxLen;
    }
}
