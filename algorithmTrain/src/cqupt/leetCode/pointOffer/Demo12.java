package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-30 9:50
 */
public class Demo12 {
    int[] dx = {0, -1, 0, 1};// 上左下右
    int[] dy = {-1, 0, 1, 0};
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null)
            return false;
        int row = board.length;
        int col = board[0].length;
        char[] chars = word.toCharArray();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == chars[0]) {
                    boolean[][] visited = new boolean[row][col];
                    visited[i][j] = true;
                    if(helper(board, chars, visited, i, j, 1))// i j 是已经被检查过的了   index是要检查的下一个
                        return true;
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, char[] chars, boolean[][] visited, int row, int col, int index) {
        if (index == chars.length)
            return true;
        for (int i = 0; i < 4; i++) {
                row += dx[i];
                col += dy[i];
                if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
                    return false;
                }
                if (visited[row][col] || board[row][col] != chars[index]) {
                    return false;
                }
                visited[row][col] = true;
                if (helper(board, chars, visited, row, col, index + 1))
                    return true;
                visited[row][col] = false;
        }
        return false;
    }
}
