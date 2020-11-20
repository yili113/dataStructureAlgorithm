package cqupt.writtenExamination.xiaoMI;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-09-08 18:30
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        if (s == null || s.length() == 0) {
            System.out.println(false);
            return;
        }
        char[][] grid = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(isOk(s, grid));
    }

    private static boolean isOk(String s, char[][] grid) {
        if (grid == null || grid.length == 0) {
            return false;
        }
        int m = grid.length;
        int n = grid[0].length;
        char[] chars = s.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == chars[0]) {
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    if (helper(grid, chars, i, j, 1, visited, m, n))
                        return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(char[][] grid, char[] chars, int i, int j, int index, boolean[][] visited,
                                  int m, int n) {
        if (index >= chars.length)
            return true;
        // 向上走
        if (i - 1 >= 0 && !visited[i - 1][j] && chars[index] == grid[i - 1][j]) {
            visited[i - 1][j] = true;
            if (helper(grid, chars, i - 1, j, index + 1, visited, m, n))
                return true;
            visited[i - 1][j] = false;
        }
        // 向下走
        if (i + 1 < m && !visited[i + 1][j] && chars[index] == grid[i + 1][j]) {
            visited[i + 1][j] = true;
            if (helper(grid, chars, i + 1, j, index + 1, visited, m, n))
                return true;
            visited[i + 1][j] = false;
        }
        // 向左走
        if (j - 1 >= 0 && !visited[i][j - 1] && chars[index] == grid[i][j - 1]) {
            visited[i][j - 1] = true;
            if (helper(grid, chars, i, j - 1, index + 1, visited, m, n))
                return true;
            visited[i][j - 1] = false;
        }
        // 向右走
        if (j + 1 < n && !visited[i][j + 1] && chars[index] == grid[i][j + 1]) {
            visited[i][j + 1] = true;
            if (helper(grid, chars, i, j + 1, index + 1, visited, m, n))
                return true;
            visited[i][j + 1] = false;
        }
        return false;
    }
}
