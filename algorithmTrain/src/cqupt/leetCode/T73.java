package cqupt.leetCode;

import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-03-09 11:34
 * 矩阵置零
 */
public class T73 {

    /**
     * 很容易想到的方法
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left;
        int right;
        int top;
        int buttom;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0 && visited[i][j] == false) {
                    visited[i][j] = true;
                    left = j - 1;
                    while (left > -1) {
                        if (matrix[i][left] != 0)// 如果该位置原本就为0  就保持false
                            visited[i][left] = true;
                        matrix[i][left] = 0;
                        left --;
                    }
                    right = j + 1;
                    while (right < n) {
                        if (matrix[i][right] != 0)
                            visited[i][right] = true;
                        matrix[i][right] = 0;
                        right++;
                    }
                    top = i - 1;
                    while (top > -1) {
                        if (matrix[top][j] != 0) {
                            visited[top][j] = true;
                        }
                        matrix[top][j] = 0;
                        top--;
                    }
                    buttom = i + 1;
                    while (buttom < m) {
                        if (matrix[buttom][j] != 0) {
                            visited[buttom][j] = true;
                        }
                        matrix[buttom][j] = 0;
                        buttom++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
//         int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};
        setZeroes(matrix);
        for(int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
