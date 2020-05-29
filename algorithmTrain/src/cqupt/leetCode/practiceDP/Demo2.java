package cqupt.leetCode.practiceDP;

/**
 * @author yiLi
 * @create 2020-05-27 15:00
 * 矩阵的最小路径和
 * 给定一个矩阵 m，从左上角开始每次只能向右或者向下走，最后到达右下角的位置，路径
 * 上所有的数字累加起来就是路径和，返回所有的路径中最小的路径和。
 */
public class Demo2 {

    public static int getMaxLen(int[][] m) {
        if (m.length == 0 || m[0].length == 0)
            return 0;
        int[][] dp = new int[m.length][m[0].length];
        // 初始化
        dp[0][0] = m[0][0];
        for (int i = 1; i < m.length; i++) {
            dp[i][0] = dp[i - 1][0] + m[i][0];
        }
        for (int i = 1; i < m[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + m[0][i];
        }
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + m[i][j];
            }
        }
        return dp[m.length - 1][m[0].length - 1];
    }
    // 使用空间压缩
    // 只创建一个一维数组去记录最大值
    public static int getMaxLen1(int[][] m) {
        if (m.length == 0 || m[0].length == 0)
            return 0;
        int len = m.length;
        int[] arr = new int[len];
        arr[0] = m[0][0];
        // 先把第一行初始化
        for (int i = 1; i < len; i++) {
            arr[i] = arr[i - 1] + m[0][i];
        }
        // 一行一行更新   从第二行开始
        for (int i = 1; i < len; i++) {
            arr[0] = arr[0] + m[i][0];
            for (int j = 1; j < len; j++) {
                arr[j] = Math.min(arr[j], arr[j - 1]) + m[i][j];
            }
        }
        return arr[len - 1];
    }

    public static void main(String[] args) {
        int[][] m = new int[][]{{1, 3, 5, 9}, {8, 1, 3, 4}, {5, 0, 6, 1}, {8, 8, 4, 0}};
        System.out.println(getMaxLen(m));
        System.out.println(getMaxLen1(m));
    }
}
