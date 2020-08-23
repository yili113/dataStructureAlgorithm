package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-08-19 19:36
 */
public class Solution1 {
    public int movingCount(int threshold, int rows, int cols)
    {
        if(rows <= 0 || cols <= 0)
            return count;
        boolean[][] visited = new boolean[rows][cols];
        helper(0, 0, threshold, rows, cols, visited);
        return count;
    }

    private int count = 0;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};

    private void helper(int i, int j, int threshold, int rows, int cols, boolean[][] visited) {
        if(i >= rows|| i < 0 || j >= cols || j < 0 || !visited[i][j] || getSum(i) + getSum(j) > threshold)
            return;
        count ++;
        visited[i][j] = true;
        for(int k = 0; k < 4; k ++) {
            helper(i + dx[k], j + dy[k], threshold, rows, cols, visited);
        }
    }

    private int getSum(int x) {
        int res = 0;
        while(x > 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
