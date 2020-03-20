package cqupt.leetCode.binaryCase;

/**
 * @author Liyi
 * @create 2020-03-11 13:27
 * 搜索二维矩阵
 * 二维矩阵是有序的
 * 使用两个二分法
 */
public class T74 {
    /**
     * 两次二分法  第一次二分法找到需要的那一行  第二次找到该值
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int startRow = 0;
        int endRow = matrix.length - 1;
        int row = -1;// 假定目标值存在的行
        while (startRow + 1 < endRow) {
            int midRow = startRow + (endRow - startRow) / 2;
            if (matrix[midRow][matrix[0].length - 1] < target) {
                startRow = midRow;
            }else {
                endRow = midRow;
            }
        }
        if (matrix[startRow][matrix[0].length - 1] >= target)
            row = startRow;
        else if (matrix[endRow][matrix[0].length - 1] >= target)
            row = endRow;
        else
            return false;

        int start = 0;
        int end = matrix[0].length - 1;
        int mid = -1;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (matrix[row][mid] > target)
                end = mid;
            else
                start = mid;
        }
        if (matrix[row][start] == target || matrix[row][end] == target)
            return true;
        return false;
    }
}
