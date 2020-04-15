package cqupt.leetCode.bfs;

import java.util.LinkedList;

/**
 * @author Liyi
 * @create 2020-04-15 11:21
 * 墙与门
 */
public class T286_wallAndDoor {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0)
            return;
        int m = rooms.length;
        int n = rooms[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[] di = {-1, 1, 0, 0};// 上下左右
        int[] dj = {0, 0, -1, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (rooms[i][j] == 0) {// 遇到门则进栈
                    queue.addLast(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.removeFirst();
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + di[i];
                int newY = cur[1] + dj[i];
                // 以下情况该位置都不能用
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || rooms[newX][newY] == -1 || visited[newX][newY] == true)
                    continue;
                rooms[newX][newY] = rooms[cur[0]][cur[1]] + 1;
                queue.addLast(new int[]{newX, newY});
                visited[newX][newY] = true;
            }
        }
    }
}
