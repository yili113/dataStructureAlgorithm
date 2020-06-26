package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-24 15:20
 */
public class Demo12 {
    // 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
    // 输出：true
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        if (word == null || word.length() == 0)
            return true;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    if (helper(board, word.toCharArray(),1, visited, m, n, i, j))
                        return true;
                }
            }
        }
        return false;
    }
    // index:将要访问的字符数组下标
    private boolean helper(char[][] board, char[] chars, int index, boolean[][] visited, int m, int n, int i, int j) {
        if (index == chars.length)
            return true;
        // 向上走
        if (i - 1 >= 0 && board[i - 1][j] == chars[index] && !visited[i - 1][j]) {
            visited[i - 1][j] = true;
            if (helper(board, chars, index + 1, visited, m,n,i - 1,j))
                return true;
            visited[i - 1][j] = false;
        }
        // 向下
        if (i + 1 < m && board[i + 1][j] == chars[index] && !visited[i + 1][j]) {
            visited[i + 1][j] = true;
            if (helper(board, chars, index + 1, visited, m,n,i + 1,j))
                return true;
            visited[i + 1][j] = false;
        }
        // 向左
        if (j - 1 >= 0 && board[i][j - 1] == chars[index] && !visited[i][j - 1]) {
            visited[i][j - 1] = true;
            if (helper(board, chars, index + 1, visited, m, n, i, j - 1))
                return true;
            visited[i][j - 1] = false;
        }
        // 向右
        if (j + 1 < n && board[i][j + 1] == chars[index] && !visited[i][j + 1]) {
            visited[i][j + 1] = true;
            if (helper(board, chars, index + 1, visited, m, n, i, j + 1))
                return true;
            visited[i][j + 1] = false;
        }
        return false;
    }
}
