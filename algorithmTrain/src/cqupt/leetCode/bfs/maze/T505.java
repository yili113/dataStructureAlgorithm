package cqupt.leetCode.bfs.maze;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Liyi
 * @create 2020-03-27 14:13
 * 迷宫2---Dijkstra---最短路径问题
 */
public class T505 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        // 定义四个方向
        int[] di = {-1, 0, 1, 0};// 上左下右
        int[] dj = {0, -1, 0, 1};
        int[][] visited = new int[m][n];// 一般遍历的问题都需要记录用于去重,只记录球停留的位置
        visited[start[0]][start[1]] = 1;
        ComPQ comPQ = new ComPQ();
        PriorityQueue<int []> pq = new PriorityQueue(comPQ);// 实现优先队列  {dist, i, j} 第一个位置放距离
        pq.add(new int[]{0, start[0], start[1]});// !!!! 起始点与起始点的距离为0
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            visited[cur[1]][cur[2]] = 1;// 当前点能使用的话再标记为已访问(也就是说从优先队列中poll出来时)
            if (cur[1] == destination[0] && cur[2] == destination[1])// 在停留的时候到终点才算,在滚动过程中经过目的地不算
                return cur[0];
            // 如果没有到目的地,就四个方向遍历
            for (int d = 0; d < 4; d++) {
                int i = cur[1];
                int j = cur[2];// 拿到当前位置
                int dist = cur[0];
                while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] == 0) {// 只要没碰壁、没越界就一直滚,只记录停留的位置
                    i += di[d];
                    j += dj[d];// 此时i,j表示下一位置
                    dist ++;// 每走一步距离+1
                }
                // 此时的位置已经在墙壁上了
                i -= di[d];
                j -= dj[d];// 回退到碰壁前的位置,表示当前停留位置
                dist --;
                if (visited[i][j] == 0) {// 当前停留位置未被访问过
                    pq.add(new int[]{dist, i, j});
                }
            }
        }
        return -1;
    }
}
class ComPQ implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
    }
}
