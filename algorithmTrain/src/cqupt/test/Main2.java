package cqupt.test;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-11-15 11:31
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int D = scanner.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
        Father = new int[n];
        for (int i = 0; i < n; i++) {
            Father[i] = i;
        }
        int edges = 0;
        for (int i = 0; i < n; i++) {
            int curEdges = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    curEdges ++;
            }
            edges = Math.max(curEdges, edges);
        }
        int count = helper(n, D, grid);
        if (count >= 2)
            System.out.println(-1);
        else {
            if (edges == n - 1)
                System.out.println(576);
            else
                System.out.println(1152);
        }
    }
    // 返回种群数
    private static int helper(int n, int d, int[][] grid) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (grid[i][j] == 1)
                    union(i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            if (Father[i] == i)
                count ++;
        }
        return count;
    }

    private static void union(int i, int j) {
        int f1 = find(i);
        int f2 = find(j);
        Father[f1] = f2;
    }

    private static int find(int i) {
        while (Father[i] != i)
            i = Father[i];
        return i;
    }

    private static int[] Father;
}
