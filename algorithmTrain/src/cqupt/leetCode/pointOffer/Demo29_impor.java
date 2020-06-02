package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-01 9:50
 * 顺时针打印矩阵
 *
 * 矩阵旋转的问题考虑用四个方向的指针解决
 */
public class Demo29_impor {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[]{};
        int m = matrix.length;
        int n = matrix[0].length;
//        int row = 0;
//        int col = 0;
        int l = 0;
        int t = 0;
        int r = n - 1;
        int b = m - 1;
        int[] res = new int[m * n];
        int index = 0;
//        while () {
//            if (col >= 0 && col < n) {
//                res[index] = matrix[row][col];
//                col ++;
//                index ++;
//            }
//            if (row >= 0 && col < m) {
//            }
//        }
        while (true) {
            for (int i = l; i <= r; i++) {
                res[index++] = matrix[t][i];
            }
            t ++;
            if (t > b)
                break;
            for (int i = t; i <= b; i++) {
                res[index ++] = matrix[i][r];
            }
            r --;
            if (l > r)
                break;
            for (int i = r; i >= l; i--) {
                res[index ++] = matrix[b][i];
            }
            b --;
            if (t > b)
                break;
            for (int i = b; i >= t; i--) {
                res[index ++] = matrix[i][l];
            }
            l ++;
            if (l > r)
                break;
        }
        return res;
    }
}
