package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-27 10:00
 */
public class T329 {

    private int MAX;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private int[][] VISITED;

    public int longestIncreasingPath(int[][] matrix) {
        MAX = Integer.MIN_VALUE;
        if (matrix == null || matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // 记忆数组
        VISITED= new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                MAX = Math.max(MAX, helper(matrix, i, j, m, n));
                if (VISITED[i][j] == 0)
                    helper(matrix, i, j, m, n);
            }
        }
        return MAX;
    }

    private int helper(int[][] matrix, int i, int j, int m, int n) {

        if (i < 0 || i >= m || j < 0 || j >= n)
            return 0;
        if (VISITED[i][j] != 0)
            return VISITED[i][j];

        VISITED[i][j] = 1;// 表示当前位置的初始值  此时最大长度是1
        for (int k = 0; k < 4; k++) {
            int newX = i + dx[k];
            int newY = j + dy[k];
            if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] > matrix[i][j]) {
                VISITED[i][j] = Math.max(VISITED[i][j], helper(matrix, newX, newY, m, n) + 1);
            }
        }
        MAX = Math.max(MAX, VISITED[i][j]);
        return VISITED[i][j];


//        if (i < 0 || i >= m || j < 0 || j >= n)
//            return 0;
//        int res = 1;// 表示当前位置  此时最大长度是1
//        // 向上
//        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j])
//            res += helper(matrix, i - 1, j, m, n);
//        if (i + 1 < m && matrix[i + 1][j] > matrix[i][j])
//            res += helper(matrix, i + 1, j, m, n);
//        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j])
//            res += helper(matrix, i, j - 1, m, n);
//        if (j + 1 < n && matrix[i][j + 1] > matrix[i][j])
//            res += helper(matrix, i, j + 1, m, n);
//        MAX = Math.max(MAX, res);
//        return res;
    }
}
