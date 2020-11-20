package cqupt.writtenExamination.bilibili;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-09-04 19:03
 */
public class Main2 {

    public int[] SpiralMatrix (int[][] matrix) {
        // write code here
        if (matrix == null || matrix.length == 0)
            return new int[]{};
        list = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int tr = 0;
        int tc = 0;
        int dr = m - 1;
        int dc = n - 1;
        while (tr <= dr && tc<= dc)
            printNum(matrix, tr++, tc++, dr--, dc --);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void printNum(int[][] matrix, int tr, int tc, int dr, int dc) {
        if (tr > dr || tc > dc)
            return;
        if (tr == dr) {
            int col = tc;
            while (col <= dc)
                list.add(matrix[tr][col ++]);
        }else if(tc == dc) {
            int row = tr;
            while (row <= dr)
                list.add(matrix[row ++][tc]);
        }else {
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

    private List<Integer> list;
}
