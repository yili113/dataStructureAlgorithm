package cqupt.leetCode.twoPointer;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-24 10:00
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][i] = a[i];
        }
        for (int i = n; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                int curSum = 0;
                for (int k = i; k <= j; k++) {
                    curSum += a[k];
                }
//                System.out.println(curSum);
                dp[i][j] = Math.max(Math.max(dp[i][j - 1], dp[i + 1][j]), curSum / (j - i + 1));
            }
        }
        System.out.println(dp[1][n]);
    }
}
