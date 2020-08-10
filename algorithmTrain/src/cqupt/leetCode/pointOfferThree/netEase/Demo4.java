package cqupt.leetCode.pointOfferThree.netEase;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-07 16:42
 */
public class Demo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] traps = new int[2][n];
        for(int i = 0; i < n; i++) {
            traps[0][i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            traps[1][i] = sc.nextInt();
        }
        sc.close();
        int minLen = Integer.MAX_VALUE;
        int curMin = 0;
        for(int i = 0; i < n; i++) {
            curMin = traps[0][i] + traps[1][i] - 2;
            minLen = Math.min(curMin, minLen);
        }
        System.out.println(minLen);
    }
}
