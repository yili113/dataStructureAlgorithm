package cqupt.leetCode.dfs;

/**
 * @author Liyi
 * @create 2020-03-15 22:49
 * 解数独---dfs
 */
public class T37 {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }

    /**
     * 在board二维数组中填数
     * @param board
     */
    private boolean dfs(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {// 是.的话就可以填数
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (dfs(board))// 当新填了一个数之后继续进行检查board数组是否有效，接着填下一个.的位置
                                return true;
                            board[i][j] = '.';//当前位置填了数导致后面数没法填的话就要回溯成.
                        }
                    }
                    return false;// 如果c从1到9遍历完都没找到满足的就返回false!!!
                }
            }
        }
        return true;// 每个位置都填了
    }

    private static boolean isValid(char[][] board, int i, int j, char c) {
        // 判断该位置对应的行和列
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c)
                return false;
            if (board[k][j] == c)
                return false;
        }
        // 判断该位置所在的小格子内是否有效
        for (int p = i / 3 * 3; p < i / 3 * 3 + 3; p++) {
            for (int q = j / 3 * 3; q < j / 3 * 3 + 3; q++) {
                if (board[p][q] == c)
                    return false;
            }
        }
        return true;
    }
}
