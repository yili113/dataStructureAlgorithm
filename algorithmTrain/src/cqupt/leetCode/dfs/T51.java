package cqupt.leetCode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-15 15:41
 * N皇后  --- DFS
 *
 * TODO
 */
public class T51 {


//    public static List<List<String>> solveNQueens(int n) {
//        ArrayList<List<String>> result = new ArrayList<>();
//        ArrayList<String> list = new ArrayList<>();
//        // 对list初始化为.
//        for (int j = 0; j < n; j++) {
//            StringBuilder stringBuilder = new StringBuilder();
//            for (int i = 0; i < n; i++) {
//                stringBuilder.append(".");
//            }
//            list.add(stringBuilder.toString());
//        }
//        dfs(result, list, n, 0);
//        return result;
//    }
//
//    private static void dfs(ArrayList<List<String>> result, ArrayList<String> list, int n, int row) {
//        if (row == n) {
//            result.add(new ArrayList<>(list));
//            return;
//        }
//        for (int col = 0; col < n; col++) {// 每行放的时候从这行的所有列中选
//            if (isValid(result, list, row, col, n)) {// 检查[row,col]能不能放
//                StringBuilder sb1 = new StringBuilder(list.get(row));
//                sb1.setCharAt(col, 'Q');
//                dfs(result, list, n, row + 1);
//                // 回溯
//                StringBuilder sb2 = new StringBuilder(list.get(row));
//                sb2.setCharAt(col, '.');
//            }
//        }
//    }
//
//    /**
//     * 检查[row,col]能不能放
//     * @param result
//     * @param list
//     * @param row
//     * @param col
//     * @return
//     */
//    private static boolean isValid(ArrayList<List<String>> result, ArrayList<String> list, int row, int col, int n) {
//        for (int i = 0; i < n; i++) {// 检查列
//            if (list.get(row).charAt(i) == 'Q') {
//                return false;
//            }
//        }
//        for (int j = 0; j < row; j++) {// 检查上面的所有行即可
//            if (list.get(j).charAt(col) == 'Q')
//                return false;
//        }
//        // 检查对角线：只需要检查左上对角线和右上对角线
//        for (int k = 0; k < Math.min(row, col); k++) {
//            if (list.get(row - k).charAt(col - k) == 'Q')
//                return false;
//        }
//        for (int k = 0; k < Math.min(row, n - col - 1); k++) {
//            if (list.get(row - k).charAt(col + k) == 'Q')
//                return false;
//        }
//        // 如果检查四个方向都没问题就true
//        return true;
//    }

    public static void main(String[] args) {
        List<int[][]> lists = solveNQueens(4);
//        List<List<String>> lists = solveNQueens(4);
        for(int[][] ints : lists) {
            for (int i = 0; i < ints.length; i++) {
                for (int j = 0; j < ints[0].length; j++) {
                    System.out.print(ints[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("####################");
        }

    }
    public static List<int[][]> solveNQueens(int n) {
        ArrayList<int[][]> res = new ArrayList<>();
        int[][] ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ints[i][j] = 0;
            }
        }
        dfs(res, ints, n, 0);
        ArrayList<List<String>> lists = new ArrayList<>();

        return res;
    }

    /**
     *
     * @param res
     * @param ints
     * @param n
     * @param row 将在第row行放置
     */
    private static void dfs(ArrayList<int[][]> res, int[][] ints, int n, int row) {
        if (row == n) {
            int[][] intss = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    intss[i][j] = ints[i][j];
                }
            }
            res.add(intss);
            return;
        }
        for (int col = 0; col < n; col++) {// 找列位置放置
            if (isValid(res, ints, n, row, col)) {
                ints[row][col] = 1;
                dfs(res, ints, n, row + 1);
                ints[row][col] = 0;
            }
        }
    }

    private static boolean isValid(ArrayList<int[][]> res, int[][] ints, int n, int row, int col) {
        // 判断列
        for (int j = 0; j < n; j++) {
            if (ints[row][j] == 1)
                return false;
        }
        // 判断行
        for (int i = 0; i < row; i++) {
            if (ints[i][col] == 1)
                return false;
        }
        // 判断左上角对角线
        for (int k = 1; k <= Math.min(row, col); k++) {
            if (ints[row - k][col - k] == 1)
                return false;
        }
        // 判断右上角对角线
        for (int p = 1; p <= Math.min(row, n - col - 1); p++) {
            if (ints[row - p][col + p] == 1)
                return false;
        }
        return true;
    }

}
