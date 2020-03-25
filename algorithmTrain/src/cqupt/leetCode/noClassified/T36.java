package cqupt.leetCode.noClassified;

/**
 * @author Liyi
 * @create 2020-03-05 9:57
 * 有效的数独
 */
public class T36 {


    /**
     * 判断有没有重复的元素的题可以定义boolean数组来解决
     * @param board
     * @return
     */
    public static boolean isValidSudoku1(char[][] board) {
        // 1.先判断每一行
        for (int row = 0; row < board.length; row++) {// 每一行都要有一个新的boolean数组 记录某个数字是否存在过
            boolean[] booleans = new boolean[board.length];
            for (int col = 0; col < board.length; col++) {
                char c = board[row][col];
                if (c != '.') {
                    int num = c - '1';// 当c是 '1'   num就为0  放在boolean数组的0下标处
                    if (booleans[num])
                        return false;
                    else booleans[num] = true;
                }
            }
        }
        // 2.再判断每一列
        for (int col = 0; col < board.length; col++) {
            boolean[] taken = new boolean[board.length];
            for (int row = 0; row < board.length; row++) {
                char c = board[row][col];
                if (c != '.') {
                    int num = c - '1';
                    if (taken[num] == true)
                        return false;
                    else taken[num] = true;
                }
            }
        }
        // 3.最后判断每个小格子
        for (int boxs = 0; boxs < 9; boxs++) {// 已知的有9个格子
            boolean[] taken = new boolean[9];
            for (int boxRow = 0; boxRow < 3; boxRow++) {// 遍历每个小格子的行
                for (int boxClo = 0; boxClo < 3; boxClo++) {// 遍历每个小格子的列
                    // 将小格子上的坐标转变到大格子上   秒！
                    char c = board[boxRow + 3 * (boxs / 3)][boxClo + 3 * (boxs % 3)];
                    if(c != '.') {
                        int num = c - '1';
                        if (taken[num])
                            return false;
                        else taken[num] = true;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] chars = {{'5','3','.','.','7','.','.','.','.'}, {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'}, {'8','.','.','.','6','.','.','.','3'}, {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'}, {'.','6','.','.','.','.','2','8','.'}, {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}};
        System.out.println(isValidSudoku1(chars));
    }

    /**
     * 思路2：判断每个位置是不是有效的
     * @param board
     * @return
     */
    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {// 此时要判断这个位置上的数字是否有效
                    char c = board[i][j];
                    board[i][j] = '.';// 先换成.然后去判断这个数字是否有效
                    if(!isValid(board, i, j, c))
                        return false;
                    board[i][j] = c;
                }
            }
        }
        return true;// 此时每个位置都检查完了 并且都是有效的
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
