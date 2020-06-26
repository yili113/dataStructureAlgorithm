package cqupt.leetCode.pointOfferTwo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-06-24 15:54
 */
public class Demo13 {
    public int movingCount1(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        helper(0, 0, m, n, k, visited);
        return sum;
    }

    private void helper(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || getNum(i) + getNum(j) > k || visited[i][j])
            return;
        sum++;
        visited[i][j] = true;
        for (int l = 0; l < 4; l++) {
            helper(i + dx[l], j + dy[l], m, n, k, visited);
        }
    }

    int sum = 0;
    int[] dx = {-1, 1, 0, 0};// 上下左右
    int[] dy = {0, 0, -1, 1};

    public int getNum(int num) {
        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }
    // bfs
    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] < 0 || cur[0] >= m || cur[1] < 0 || cur[1] >= n || cur[3] + cur[2] > k || visited[cur[0]][cur[1]])
                continue;
            sum ++;
            visited[cur[0]][cur[1]] = true;
            // 把相邻的加进队列
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                queue.offer(new int[]{newX, newY, getNum(newX), getNum(newY)});
            }
        }
        return sum;
    }
}