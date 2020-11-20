package cqupt.writtenExamination.keDaXunFei;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-29 19:03
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int m = sc.nextInt();
//        int n = sc.nextInt();
        String s = sc.next();
        String[] strs = s.split(",");
        int m = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        System.out.println(dp[m - 1][n - 1]);
    }
}
