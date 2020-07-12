package cqupt.leetCode.pointOfferTwo.unionFind;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-07-11 12:22
 */
public class Demo200 {
    // unionFind
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        Father = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            Father[i] = i;// 每个结点的父结点先置为自身
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0')// 遇到水就跳过
                    continue;
                int curPos = n * i + j;
                // 上下左右判断
                if (i - 1 >= 0 && grid[i - 1][j] == '1')
                    union(curPos, curPos - n);
                if (i + 1 < m && grid[i + 1][j] == '1')
                    union(curPos, curPos + n);
                if (j - 1 >= 0 && grid[i][j - 1] == '1')
                    union(curPos, curPos - 1);
                if (j + 1 < n && grid[i][j + 1] == '1')
                    union(curPos, curPos + 1);
            }
        }
        int count = 0;
//        for (int i = 0; i < Father.length; i++) {
//            if (Father[i] == i)
//                count ++;
//        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curPos = n * i + j;
                if (grid[i][j] == '1' && Father[curPos] == curPos)// 满足岛屿的前提是该位置是 陆地'1'
                    count++;
            }
        }
        return count;
    }

    private void union(int i, int j) {
        int f1 = find(i);
        int f2 = find(j);
        Father[f1] = f2;
    }

    private int find(int i) {
        while (Father[i] != i)
            i = Father[i];
        return i;
    }

    private int[] Father;

    // dfs
    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        COUNT = 0;
        VISITED = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !VISITED[i][j]) {
                    dfs(grid, i, j);
                    COUNT++;
                }
            }
        }
        return COUNT;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
                || VISITED[i][j] || grid[i][j] == '0')
            return;
        VISITED[i][j] = true;// 到这儿就说明是没被访问过的'1'
        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            dfs(grid, newX, newY);
        }
    }

    private static int COUNT;
    private static boolean[][] VISITED;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    // bfs
    // [
    //['1','1','0','0','0'],
    //['1','1','0','0','0'],
    //['0','0','1','0','0'],
    //['0','0','0','1','1']
    //]
    public static int numIslands3(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        COUNT = 0;
        VISITED = new boolean[m][n];
        Queue<Pos200> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !VISITED[i][j]) {
                    queue.add(new Pos200(i, j));
                    while (!queue.isEmpty()) {
                        Pos200 cur = queue.poll();
                        int curX = cur.x;
                        int curY = cur.y;
                        VISITED[curX][curY] = true;// 访问的置为true
                        for (int k = 0; k < 4; k++) {
                            int newX = curX + dx[k];
                            int newY = curY + dy[k];
                            if (newX < 0 || newX >= m || newY < 0 || newY >= n
                                    || grid[newX][newY] == '0' || VISITED[newX][newY])
                                continue;
                            queue.add(new Pos200(newX, newY));
                        }
                    }
                    COUNT ++;
                }
            }
        }
        return COUNT;
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println(numIslands3(grid));
    }
}
class Pos200 {
    int x;
    int y;

    public Pos200(int x, int y) {
        this.x = x;
        this.y = y;
    }
}