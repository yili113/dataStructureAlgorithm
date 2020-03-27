package cqupt.leetCode.noClassified;

/**
 * @author Liyi
 * @create 2020-03-26 20:22
 */
public class T999 {
    public static int numRookCaptures(char[][] board) {
        if (board == null || board.length == 0)
            return 0;
        int m = board.length;
        int n = board[0].length;
        int rI = 0;
        int rJ = 0;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'R') {
                    rI = i;
                    rJ = j;
                    break;
                }
            }
        }
        // 向上走
        int i = rI;
        int j = rJ;
        while(i - 1 >= 0 && board[i - 1][j] != 'B') {
            if (board[i - 1][j] == 'p'){
                count ++;
                break;
            }
            i --;
        }
        // 向左走
        while (j - 1 >= 0 && board[i][j - 1] != 'B') {
            if (board[i][j - 1] == 'p'){
                count ++;
                break;
            }
            j --;
        }
        i = rI;
        j = rJ;
        // 向下走
        while (i + 1 < m && board[i + 1][j] != 'B') {
            if (board[i + 1][j] == 'p'){
                count ++;
                break;
            }
            i ++;
        }
        // 向右走
        while (j + 1 < n && board[i][j + 1] != 'B') {
            if (board[i][j + 1] == 'p'){
                count ++;
                break;
            }
            j ++;
        }
        return count;
    }
}
