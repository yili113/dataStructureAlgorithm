package cqupt.leetCode.matrix;

import java.util.ArrayList;

/**
 * @author yiLi
 * @create 2020-07-11 14:14
 */
public class Demo1 {

    private ArrayList<Integer> list;
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0)
            return new int[]{};
        list = new ArrayList<>();
        int tR = 0;// 子矩阵左上角元素的横坐标
        int tC = 0;// 子矩阵左上角元素的纵坐标
        int dR = matrix.length - 1;// 子矩阵右下角元素的横坐标
        int dC = matrix[0].length - 1;// 子矩阵右下角元素的纵坐标
        while (tR <= dR && tC <= dC)
            printMatrix(matrix, tR ++, tC ++, dR --, dC --);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void printMatrix(int[][] matrix, int tr, int tc, int dr, int dc) {
        if (tr > dr || tc > dc)
            return;// 越界
        // 只有一行
        if (tr == dr) {
            int curC = tc;
            while (curC <= dc)
                list.add(matrix[tr][curC ++]);
        }else if (tc == dc) {// 只有一列
            int curR = tr;
            while (curR <= dr)
                list.add(matrix[curR ++][tc]);
        }else {
            int curC = tc;
            int curR = tr;
            while (curC != dc) {
                list.add(matrix[tr][curC ++]);
            }
            while (curR != dr)
                list.add(matrix[curR ++][dc]);
            while (curC != tc)
                list.add(matrix[dr][curC --]);
            while (curR != tr)
                list.add(matrix[curR --][tc]);
        }
    }
}
