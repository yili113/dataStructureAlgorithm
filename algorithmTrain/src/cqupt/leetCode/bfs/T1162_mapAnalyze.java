package cqupt.leetCode.bfs;

import java.util.LinkedList;

/**
 * @author Liyi
 * @create 2020-03-29 22:52
 * 地图分析---bfs
 */
public class T1162_mapAnalyze {
    /**
     * 把所有的陆地全部加进队列，然后将队列中的陆地同时向外扩散，(比如说第一次扩散到的海洋都是距离陆地为一个单位的海洋)
     * 最后扩散到的海洋肯定就是离所有陆地最远的海洋
     * 并且这个海洋肯定是被离他最近的陆地给扩散到的
     * @param grid
     * @return
     */
    public int maxDistance(int[][] grid) {
        int[] di = {-1, 1, 0, 0};// 上下左右
        int[] dj = {0, 0, -1, 1};
        // 把所有的陆地先都加入队列
        LinkedList<int[]> queue = new LinkedList<>();// 队列中存放坐标
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    queue.addLast(new int[]{i, j});
            }
        }
        // 将所有的陆地同时向外扩散，遍及所有的海洋
        int[] point = null;// 如果point最后仍为null的话就说明没有陆地
        boolean hasOcean = false;
        while (!queue.isEmpty()) {
            point = queue.removeFirst();
            int curX = point[0];
            int curY = point[1];
            for (int d = 0; d < 4; d++) {
                int newX = curX + di[d];// 上下左右遍历
                int newY = curY + dj[d];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || grid[newX][newY] != 0)
                    continue;
                // 新的坐标满足扩散条件
                grid[newX][newY] = grid[curX][curY] + 1;// 表明这个扩散位置是有上一个位置扩散来的 编号+1
                queue.addLast(new int[]{newX, newY});
                hasOcean = true;// 说明有海洋
            }
        }
        if (point == null || !hasOcean)// 没有海洋或者没有陆地
            return -1;
        return grid[point[0]][point[1]] - 1;// point最后指向的位置就是最后扩散到的海洋，并且其编号就是该海洋到其最近陆地的距离
    }
}
