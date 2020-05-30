package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-29 15:06
 */
public class Demo04 {
    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        return helper(matrix, target, 0, 0);
    }

    private boolean helper(int[][] matrix, int target, int row, int col) {
        if (matrix[row][col] == target)
            return true;
        if (row >= matrix.length || col >= matrix[0].length)
            return false;
        return helper(matrix, target, row + 1, col) || helper(matrix, target, row, col + 1)
                || helper(matrix, target, row + 1, col + 1);
    }
    // 当前行 向右数值增加   当前列 向下数值增加
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            if (target > matrix[row][col])
                row ++;
            else if (target < matrix[row][col])
                col --;
            else
                return true;
        }
        return false;
    }
}
