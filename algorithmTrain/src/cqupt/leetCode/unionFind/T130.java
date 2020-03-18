package cqupt.leetCode.unionFind;

/**
 * @author Liyi
 * @create 2020-03-18 11:22
 * 被围绕的区域
 * 多个if+continue跟if-elseif-else效果一样
 */
public class T130 {
    static int[] father;
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        if (m == 0 || n == 0) {
            return;
        }
        father = new int[m * n + 1];
        for (int i = 0; i <= m * n; i++) {
            father[i] = i;// m*n的位置放dummy结点 用于与边界上的O组成群体
        }
        int dummy = m * n;// 定义dummy结点
        // 1.将所有边界的O和与其相连的O都跟dummy合成一个群体
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X') {
                    continue;
                }
                int cur_pos = i * n + j;
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {// 当O在边界的时候就跟dummy组成一个群体
                    union(cur_pos, dummy);
                    continue;
                }
                // 此时判断上下左右的 不用再做边界判断，上面已经做完了
                if (board[i - 1][j] == 'O')
                    union(cur_pos, cur_pos - n);// 这四个方向上的操作就能把与边界的O相邻的O合并到dummy那个群体中
                if (board[i + 1][j] == 'O')
                    union(cur_pos, cur_pos + n);
                if (board[i][j + 1] == 'O')
                    union(cur_pos, cur_pos + 1);
                if (board[i][j - 1] == 'O')
                    union(cur_pos, cur_pos - 1);
            }
        }
        // 2.将除了dummy群体之外的为O的群体都置为X(这个群体O都是被X包围的)
        int dummy_father = father[dummy];// dummy的父结点可能被置换掉了
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X')
                    continue;
                int cur_pos = i * n + j;
                if (find(cur_pos) != dummy_father)// 将除了dummy群体之外的为O的群体都置为X
                    board[i][j] = 'X';
            }
        }
    }

    private void union(int j, int i) {
        int f1 = find(j);
        int f2 = find(i);
        father[f1] = f2;
    }

    private int find(int i) {
        while (father[i] != i)
            i = father[i];
        return i;
    }
}
