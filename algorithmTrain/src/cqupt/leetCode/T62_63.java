package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-08 14:41
 */
public class T62_63 {


    public int uniquePaths(int m, int n) {
        if (m < 1 && n < 1)
            return 0;
        int[][] dp = new int[m][n];
        // 初始化
        // 第一行或者第一列每个格子只能有一条路
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 1;
        }
        // 跳过第一行和第一列开始计算
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // 每个格子只能是从上面来的或者从左边来的
                // 所以等于两条路线的情况和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];// 状态方程
            }
        }
        return dp[m - 1][n - 1];// 结果是二维数组的右下角元素
    }

    /**
     *
     * @param obstacleGrid 包含障碍物的二维数组地图
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        // 初始化
        // 对于第一行或者第一列来说 只要有一个格子是障碍物 那么其后面的格子都是没法走到的
        for (int i = 0; i < dp.length; i++) {
            if (obstacleGrid[i][0] == 1)
                break;// 遇到障碍物直接break 后面都没法走到
            dp[i][0] = 1;
        }
        for (int i = 0; i < dp[0].length; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            dp[0][i] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // 到某一个格子时候先判断该处有没有障碍物
                if (obstacleGrid[i][j] == 1)
                    continue;// 发现障碍物 continue,跳过当前这个格子
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];// 状态方程
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
