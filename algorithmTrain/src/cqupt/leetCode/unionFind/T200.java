package cqupt.leetCode.unionFind;

/**
 * @author Liyi
 * @create 2020-03-18 9:31
 * 岛屿数量---union find
 */
public class T200 {

    static int[] father;

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0 || n == 0)
            return 0;
        for (int i = 0; i < m * n; i++) {// 对father初始化
            father[i] = i;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 如果当前位置是海洋 则看下一个位置
                if (grid[i][j] == '0')
                    continue;
                int cur_pos = i * n + j;// 二维坐标转成一维坐标
                // 向上找看看能不能组成岛屿
                if (i > 0 && grid[i - 1][j] == '1') {// 当前位置的岛可以和上面的岛形成岛屿
                    union(cur_pos, cur_pos - n);
                }
                // 向左找一下能不能组成岛屿
                if (j > 0 && grid[i][j - 1] == '1') {
                    union(cur_pos, cur_pos - 1);
                }
                // 因为遍历找的时候是一行一列顺序找的，所以找相邻的岛只需要找上面的和左面的
            }
        }
        // 计算形成的岛屿数量
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur_pos = i * n + j;
                if (grid[i][j] == '1' && father[cur_pos] == cur_pos) {
                    count ++;
                }
            }
        }
        return count;
    }

    private void union(int i, int j) {
        int f1 = find(i);
        int f2 = find(j);
        father[f2] = f1;
    }

    private int find(int i) {
        while (father[i] != i)
            i = father[i];
        return i;
    }
}
