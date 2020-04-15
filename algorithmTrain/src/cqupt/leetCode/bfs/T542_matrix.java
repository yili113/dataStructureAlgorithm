package cqupt.leetCode.bfs;

import java.util.LinkedList;

/**
 * @author Liyi
 * @create 2020-04-15 10:27
 * 矩阵---BFS
 */
public class T542_matrix {
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[m][n];
        if (m == 0 && n == 0)
            return res;
        int[] di = {-1, 1, 0, 0};// 上下左右
        int[] dj = {0, 0, -1, 1};
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.addLast(new int[]{i , j});
                    res[i][j] = 0;
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.removeFirst();
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + di[i];
                int newY = cur[1] + dj[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY] == true )
                    continue;
                res[newX][newY] = res[cur[0]][cur[1]] + 1;
                visited[newX][newY] = true;
                queue.addLast(new  int[]{newX, newY});
            }
        }
        return res;
    }
}
