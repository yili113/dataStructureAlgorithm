package cqupt.leetCode;

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
    public static boolean isValidSudoku(char[][] board) {
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
        System.out.println(isValidSudoku(chars));
    }
}
