package cqupt.leetCode.matrix;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-07-11 14:48
 */
public class Demo2 {
    public static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        int tX = 0;
        int tY = 0;
        int bX = m - 1;
        int bY = n - 1;
        while (tX <= bX && tY <= bY) {
            helper(matrix, tX ++, tY ++, bX --, bY --);
        }
    }

    private static void helper(int[][] matrix, int tX, int tY, int bX, int bY) {
        int times = bX - tX;
        int temp = 0;
        for (int i = 0; i < times; i++) {
            temp = matrix[tX][tY + i];
            matrix[tX][tY + i] = matrix[bX - i][tY];
            matrix[bX - i][tY] = matrix[bX][bY - i];
            matrix[bX][bY - i] = matrix[tX + i][bY];
            matrix[tX + i][bY] = temp;
        }
    }

    private static int[][] MATRIX;

    public static void main(String[] args) {
        MATRIX = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(MATRIX);
        for (int[] arr : MATRIX)
            System.out.println(Arrays.toString(arr));
    }
}
