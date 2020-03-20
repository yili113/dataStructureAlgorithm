package cqupt.leetCode.dfs;

/**
 * @author Liyi
 * @create 2020-03-12 10:05
 * 单词搜索
 * 递归+回溯
 */
public class T79 {

    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {// 原图的每个位置都要作为单词的开头试一下
//                flag = helper(board, visited, word.toCharArray(), 0, row, col);// 这种写法的弊端是 假设某一处作为开始能组成单词
                // 此时flag为true,但是没有及时返回，会接着遍历下一个位置，下一位置flag为false就把之前的覆盖了
                if (helper(board, visited, word.toCharArray(), 0, row, col))// 只要有一个位置为开头时能构成单词，立马返回true
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[][] board, boolean[][] visited, char[] chars, int idx, int row, int col) {
        if (idx == chars.length)
            return true;// 如果能把chars遍历完就说明找到了
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;// 当搜索的值的索引出界时返回false
        if (visited[row][col] || chars[idx] != board[row][col])
            return false;// 当前的元素已被访问过就不能访问了 再访问就算构成单词也是false
        // 除了上述情况 就要上下左右分别找了
        // 此时chars[idx] == board[row][col] 将当前位置置为true
        visited[row][col] = true;
        // 上
        boolean exist = helper(board, visited, chars, idx + 1, row - 1, col);
        if (exist)
            return true;
        // 下
        exist = helper(board, visited, chars, idx + 1, row + 1, col);
        if (exist)
            return true;
        // 左
        exist = helper(board, visited, chars, idx + 1, row, col - 1);
        if (exist)
            return true;
        // 右
        exist = helper(board, visited, chars, idx + 1, row, col + 1);
        if (exist)
            return true;
        // 上下左右都不行的话  要回溯  当前位置置为false
        visited[row][col] = false;

        return false;
    }

    public boolean exist1(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == chars[0]) {// 先将word的第一个字母匹配上
                    boolean[][] visited = new boolean[m][n];
                    visited[i][j] = true;
                    if(dfs(board, chars, 1, visited, i, j, m, n))
                        return true;
                }
            }
        }
        // 当所有的遍历完还没找到就false
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, int index, boolean[][] visited, int i, int j, int m, int n) {
        if (index == chars.length)// 只要能到这一步就说明找到了
            return true;
        if (i > 0 && !visited[i - 1][j] && chars[index] == board[i - 1][j]) {// 向上找
            visited[i - 1][j] = true;
            if(dfs(board, chars, index + 1, visited, i - 1, j, m, n))
                return true;
            visited[i - 1][j] = false;
        }
        if (i < m - 1 && !visited[i + 1][j] && chars[index] == board[i + 1][j]) {// 向下找
            visited[i + 1][j] = true;
            if(dfs(board, chars, index + 1, visited, i + 1, j, m, n))
                return true;
            visited[i + 1][j] = false;
        }
        if (j > 0 && !visited[i][j - 1] && chars[index] == board[i][j - 1]) {// 向左找
            visited[i][j - 1] = true;
            if(dfs(board, chars, index + 1, visited, i, j - 1, m, n))
                return true;
            visited[i][j - 1] = false;
        }
        if (j < n - 1 && !visited[i][j + 1] && chars[index] == board[i][j + 1]) {// 向右找
            visited[i][j + 1] = true;
            if(dfs(board, chars, index + 1, visited, i, j + 1, m, n))
                return true;
            visited[i][j + 1] = false;
        }
        return false;
    }
}
