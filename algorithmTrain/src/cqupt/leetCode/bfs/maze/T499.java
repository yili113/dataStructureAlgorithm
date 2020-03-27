package cqupt.leetCode.bfs.maze;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Liyi
 * @create 2020-03-27 15:28
 * 迷宫3
 */
public class T499 {
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        String res = "impossible";
        int m = maze.length;
        int n = maze[0].length;
        int[] di = {-1, 0, 1, 0};// 上左下右
        int[] dj = {0, -1, 0, 1};
        char[] dir = {'u', 'l', 'd', 'r'};// 定义路径方向
        int[][] visited = new int[m][n];
        int minPath = Integer.MAX_VALUE;
        ComPos comPos = new ComPos();
        Position start = new Position(0, ball[0], ball[1], "");
        PriorityQueue<Position> pq = new PriorityQueue(comPos);
        pq.add(start);// 起始点加入优先队列
        while (!pq.isEmpty()) {
            Position cur = pq.poll();
            // 如果当前的dist大于之前的最小值,就不要这个dist
            if (cur.dist > minPath)
                continue;
            // 1.如果到洞了
            if (cur.i == hole[0] && cur.j == hole[1]) {
                if (cur.dist < minPath) {// 1.1当前到洞距离不是最短距离
                    minPath = cur.dist;
                    res = cur.str;
                }else if (cur.dist == minPath) {// 1.2已经是最短距离了,就按照字典排序给出路径
                    // 比较res和cur.str的字典排序 java中用 compareTo() 若是负数就表明前者在后者按照字典顺序在前,数值为相隔多少个单位
                    int bool = cur.str.compareTo(res);
                    if (bool <= 0) {
                        res = cur.str;
                    }
                }
            }
            visited[cur.i][cur.j] = 1;
            // 没到洞就四个方向走
            for (int d = 0; d < 4; d++) {
                int i = cur.i;
                int j = cur.j;
                int dist = cur.dist;
                String str = cur.str;
                str += dir[d];// 将路径方向加上
                while (i >= 0 && i < m && j >= 0 && j < n && maze[i][j] == 0) {
                    if (i == hole[0] && j == hole[1]) {
                        i += di[d];
                        j += dj[d];
                        dist ++;
                        break;
                    }
                    i += di[d];
                    j += dj[d];
                    dist ++;
                }
                // 已经撞到墙
                i -= di[d];
                j -= dj[d];
                dist --;
                if (visited[i][j] == 0) {// 该点没有被访问过,就加入队列
                    Position curPos = new Position(dist, i, j, str);
                    pq.add(curPos);
                }
            }
        }
        return res;
    }
}
class Position {
    int dist;
    int i;
    int j;
    String str;

    public Position(int dist, int i, int j, String str) {
        this.dist = dist;
        this.i = i;
        this.j = j;
        this.str = str;
    }
}
class ComPos implements Comparator<Position> {
    @Override
    public int compare(Position o1, Position o2) {
        return o1.dist - o2.dist;
    }
}
