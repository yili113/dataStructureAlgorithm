package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-18 14:32
 * 矩阵中的路径
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 */
public class Demo12 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (board[i][j] == chars[0]) {
                    visited[i][j] = true;
                    if (helper(board, i, j, visited, chars, m, n, 1))
                        return true;
                }
            }
        }
        return false;
    }

    // index表示将要判断的word中字符下标
    private boolean helper(char[][] board, int i, int j, boolean[][] visited, char[] chars, int m, int n, int index) {
        if (index >= chars.length)
            return true;
        // 向上判断
        if (i - 1 >= 0 && !visited[i - 1][j] && chars[index] == board[i - 1][j]) {
            visited[i - 1][j] = true;
            if (helper(board, i - 1, j, visited, chars, m, n, index + 1))
                return true;
            visited[i - 1][j] = false;
        }
        // 向下判断
        if (i + 1 < m && !visited[i + 1][j] && chars[index] == board[i + 1][j]) {
            visited[i + 1][j] = true;
            if (helper(board, i + 1, j, visited, chars, m, n, index + 1))
                return true;
            visited[i + 1][j] = false;
        }
        // 向左判断
        if (j - 1 >= 0 && !visited[i][j - 1] && chars[index] == board[i][j - 1]) {
            visited[i][j - 1] = true;
            if (helper(board, i, j - 1, visited, chars, m, n, index + 1))
                return true;
            visited[i][j - 1] = false;
        }
        if (j + 1 < n && !visited[i][j + 1] && chars[index] == board[i][j + 1]) {
            visited[i][j + 1] = true;
            if (helper(board, i, j + 1, visited, chars, m, n, index + 1))
                return true;
            visited[i][j + 1] = false;
        }
        return false;
    }
}
