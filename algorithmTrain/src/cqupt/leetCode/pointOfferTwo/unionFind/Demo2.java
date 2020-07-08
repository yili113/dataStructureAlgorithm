package cqupt.leetCode.pointOfferTwo.unionFind;

import java.util.*;

/**
 * @author yiLi
 * @create 2020-07-08 9:45
 * 被围绕的区域
 * 将被X包围起来的O换成X
 * 只要与边界上的O相连就不会被包围
 */
public class Demo2 {
    public static void solve1(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        FATHER = new int[m * n + 1];
        int dummy = m * n;// 这个father相连的O都不能被换成X
        // 初始化父结点
        for (int i = 0; i <= m * n; i++) {
            FATHER[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X')
                    continue;
                // 下面的全是O的情况了
                // 将二维位置换成一维
                int curPos = n * i + j;
                if (i == 0 || i == m - 1 || j == 0 || j == n -1) {
                    union(dummy, curPos);
                    continue;
                }
                // 判断curPos的周围是否有O
                // 此处不考虑是否跟边界上的O相连
                if (board[i - 1][j] == 'O')
                    union(curPos, curPos - n);
                if (board[i + 1][j] == 'O')
                    union(curPos,curPos + n);
                if (board[i][j - 1] == 'O')
                    union(curPos, curPos - 1);
                if (board[i][j + 1] == 'O')
                    union(curPos, curPos + 1);
            }
        }
        // 将与dummy相连的O都置换成X
        int dummyFather = FATHER[dummy];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int curPos = i * n + j;
                if (board[i][j] == 'X')
                    continue;
                // 此时都是O的情况
                if (find(curPos) != find(dummyFather))// 这个地方不能写成dummyFather,那样就写死了,要继续找dummyFather的父结点
                    board[i][j] = 'X';
            }
        }
    }

    private static void union(int i, int j) {
        int f1 = find(i);
        int f2 = find(j);
        FATHER[f1] = f2;// f1的父结点设置成f2
    }

    private static int find(int i) {
        while (FATHER[i] != i)
            i = FATHER[i];
        return i;
    }

    static int[] FATHER;


    public static void main(String[] args) {
//        char[][] board = {{'O','O'},{'O','O'}};
//        char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        solve3(board);
        for (char[] chars : board)
            System.out.println(Arrays.toString(chars));
    }

    public static void solve2 (char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        // dfs是从边界的O开始找,这样找下去只要是O就不会被包围
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean isEdge = i == 0 || i == m - 1 || j == 0 || j == n -1;
                if (isEdge && board[i][j] == 'O')
                    dfs(board, i, j);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#'
            || board[i][j] == 'X')
            return;
        board[i][j] = '#';// 与边界O相连的O先置为#
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }

    public static void solve3(char[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        // 首先把边界上的O放进队列
        Queue<Pos> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == m - 1|| j == 0 || j == n - 1)) {
                    Pos curPos = new Pos(i, j);
                    queue.offer(curPos);
                    board[i][j] = '#';
                }
            }
        }
        while (!queue.isEmpty()) {
            Pos curPos = queue.poll();
            int curX = curPos.x;
            int curY = curPos.y;
            for (int i = 0; i < 4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || board[newX][newY] == 'X'
                    || board[newX][newY] == '#')
                    continue;
                queue.offer(new Pos(newX,newY));
                board[newX][newY] = '#';
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
    static int[] dx = {-1, 1, 0, 0};// 上下左右
    static int[] dy = {0, 0, -1, 1};
}
class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
