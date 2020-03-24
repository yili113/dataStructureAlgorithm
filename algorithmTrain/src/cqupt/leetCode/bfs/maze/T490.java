package cqupt.leetCode.bfs.maze;

import java.util.LinkedList;

/**
 * @author Liyi
 * @create 2020-03-22 15:05
 * 迷宫问题---bfs
 */
public class T490 {


    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        // 定义四个方向
        int[] di = {-1, 0, 1, 0};// 上左下右
        int[] dj = {0, -1, 0, 1};
        int[][] visited = new int[m][n];// 一般遍历的问题都需要记录用于去重,只记录球停留的位置
        visited[start[0]][start[1]] = 1;
        LinkedList<int[]> queue = new LinkedList<>();// 队列中只保存球停留的位置
        queue.addLast(start);
        while (!queue.isEmpty()) {
            int[] cur = queue.removeFirst();// 将当前停留的位置pop出
            if (cur == destination)// 在停留的时候到终点才算,在滚动过程中经过目的地不算
                return true;
            // 如果没有到目的地,就四个方向遍历
            for (int d = 0; d < 4; d++) {
                int i  = cur[0];
                int j  = cur[1];// 拿到当前位置
                while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] == 0) {// 只要没碰壁、没越界就一直滚,只记录停留的位置
                    i += di[d];
                    j += dj[d];// 此时i,j表示下一位置
                }
                // 此时的位置已经在墙壁上了
                i -= di[d];
                j -= dj[d];// 回退到碰壁前的位置,表示当前停留位置
                if (visited[i][j] == 0) {// 当前停留位置未被访问过
                    visited[i][j] = 1;
                    int[] curPos = new int[2];
                    curPos[0] = i;
                    curPos[1] = j;
                    queue.addLast(curPos);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
//[0,4]
//[4,4]
        int[][] maze = {{0,0,1,0,0}, {0,0,0,0,0}, {0,0,0,1,0}, {1,1,0,1,1}, {0,0,0,0,0}};
        int[] start = {0, 4};
        int[] destination = {4, 4};
        System.out.println(hasPath(maze, start, destination));
    }
}
