package cqupt.leetCode.pointOfferThree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-07-24 14:27
 * 顺时针打印矩阵
 */
public class Demo29 {
    private List<Integer> list;
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return new int[]{};
        list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int tr = 0;// 左上角的横坐标
        int tc = 0;// 左上角的纵坐标
        int dr = m - 1;// 右下角的横坐标
        int dc = n - 1;// 右下角的纵坐标
        while (tr <= dr && tc <= dc) {
            printNum(matrix, tr ++, tc ++, dr ++, dc ++);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void printNum(int[][] matrix, int tr, int tc, int dr, int dc) {
        if (tr > dr || tc > dc)
            return;// 越界
        if (tr == dr) {// 只有一行的情况
            int col = tc;
            while (col <= dc)
                list.add(matrix[tr][col ++]);
        } else if (tc == dc) {// 只有一列的情况
            int row = tr;
            while (row <= dr)
                list.add(matrix[row ++][tc]);
        } else {
            int row = tr;
            int col = tc;
            while (col != dc)
                list.add(matrix[tr][col ++]);
            while (row != dr)
                list.add(matrix[row ++][dc]);
            while (col != tc)
                list.add(matrix[dr][col --]);
            while (row != tr)
                list.add(matrix[row --][tc]);
        }
    }
}
