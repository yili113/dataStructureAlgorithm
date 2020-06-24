package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-23 9:09
 */
public class Demo04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && row >= 0 && col < n && col >= 0) {
            if (matrix[row][col] == target)
                return true;
            else if (matrix[row][col] > target)
                col --;
            else if (matrix[row][col] < target)
                row ++;
        }
        return false;
    }
}
