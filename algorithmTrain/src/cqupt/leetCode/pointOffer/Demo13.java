package cqupt.leetCode.pointOffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-05-30 10:59
 * 机器人的运动范围
 */
public class Demo13 {
    private int sum = 0;
    private int[] dx = {0, -1, 0, 1};// 上左下右
    private int[] dy = {-1, 0, 1, 0};
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        helper(0,0,m,n,k,visited);
        return sum;
    }

    private void helper(int i, int j, int m, int n, int k, boolean[][] visited) {
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || getSum(i) + getSum(j) > k)
            return;
        sum ++;
        visited[i][j] = true;
        for (int index = 0; index < 4; index++) {
            helper(i + dx[index], j + dy[index], m, n, k, visited);
        }
    }
    // bfs
    public int movingCount1(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] < 0 || cur[0] >= m || cur[1] < 0 || cur[1] >= n || visited[cur[0]][cur[1]] || cur[2] + cur[3] > k)
                continue;
            sum ++;
            visited[cur[0]][cur[1]] = true;
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                queue.offer(new int[]{newX, newY, getSum(newX), getSum(newY)});
            }
        }
        return sum;
    }

    private int getSum(int n) {
        int s = 0;
        while (n != 0) {
            s += n % 10;
            n /= 10;
        }
        return s;
    }
}
