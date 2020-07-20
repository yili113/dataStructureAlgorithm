package cqupt.leetCode.pointOfferThree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-07-19 12:04
 * 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1]
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外）
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37]
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 */
public class Demo13 {

    private int COUNT;
    private boolean[][] VISITED;
    private int[] dx = {-1, 1, 0, 0};// 上下左右
    private int[] dy = {0, 0, -1, 1};

    //dfs
    public int movingCount1(int m, int n, int k) {
        COUNT = 0;
        VISITED = new boolean[m][n];
        helper(0, 0, m, n, k);
        return COUNT;
    }

    private void helper(int x, int y, int m, int n, int k) {
        // 出口条件
        if (x >= m || x < 0 || y >= n || y < 0 || getNumSum(x) + getNumSum(y) > k || VISITED[x][y])
            return;
        // dfs中逻辑操作
        COUNT ++;
        VISITED[x][y] = true;
        // 四个方向走
        for (int i = 0; i < 4; i++) {
            helper(x + dx[i], y + dy[i], m, n, k);
        }
        /**
         * 此处不需要回溯！
         * 个人觉得是 本地是判断某个位置是否能达到,主要就是不能越界和不能数位和大于k
         * 这样的话当前位置就跟前一位置没什么关系了
         * 也就是说前一位置是否能满足条件不影响后面位置
         * 但是此题肯定还是会  当前位置满足,其上一位置肯定满足
         */
//        // 回溯
//        COUNT --;
//        VISITED[x][y] = false;
    }

    // bfs
    // TODO
    public int movingCount2(int m, int n, int k) {
        COUNT = 0;
        VISITED = new boolean[m][n];
        // 队列中存放 x,y,curK
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            COUNT ++;
            VISITED[curX][curY] = true;
            int newX = 0;
            int newY = 0;
            for (int i = 0; i < 4; i++) {
                newX = curX + dx[i];
                newY = curY + dy[i];
                if (getNumSum(newX) + getNumSum(newY) > k || newX >= m || newX < 0
                    || newY >= n || newY < 0 || VISITED[newX][newY])
                    continue;
                queue.add(new int[]{newX, newY});
            }
        }
        return COUNT;
    }

    // bfs
    public int movingCount3(int m, int n, int k) {
        COUNT = 0;
        VISITED = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] < 0 || cur[0] >= m || cur[1] < 0 || cur[1] >= n
                || cur[2] + cur[3] > k || VISITED[cur[0]][cur[1]])
                continue;
            COUNT ++;
            VISITED[cur[0]][cur[1]] = true;
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                queue.add(new int[]{newX, newY, getNumSum(newX), getNumSum(newY)});
            }
        }
        return COUNT;
    }

    private int getNumSum(int val) {
        int res = 0;
        while (val > 0) {
            res += val % 10;
            val /= 10;
        }
        return res;
    }
}
