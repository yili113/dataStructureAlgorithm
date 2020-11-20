package cqupt.writtenExamination.jD;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-27 18:59
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 2 * n - 1;
        int[][] nums = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            int index = n - i - 1;
            for (int j = 0; j < (i + 1) * 2 - 1; j++) {
                nums[i][index ++] = sc.nextInt();
            }
        }
        sc.close();
        dp[0][dp[0].length / 2] = nums[0][nums[0].length / 2];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = nums[i][j] + dp[i - 1][j + 1];
                }else if (j == dp[0].length - 1) {
                    dp[i][j] = nums[i][j] + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i - 1][j - 1], dp[i - 1][j + 1])) + nums[i][j];
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp[0].length; i++) {
            max = Math.max(max, dp[n - 1][i]);
        }
        System.out.println(max);
    }
}
