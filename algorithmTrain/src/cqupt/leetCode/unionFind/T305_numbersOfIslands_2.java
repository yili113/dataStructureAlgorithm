package cqupt.leetCode.unionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-04-16 16:46
 * 岛屿的数量2
 */
public class T305_numbersOfIslands_2 {
    static int[] fathers;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        ArrayList<Integer> res = new ArrayList<>();
        int[][] grid = new int[m][n];// 初始状态全为0  全是水
        fathers = new int[m * n];
        // 初始化父结点
        for (int i = 0; i < m * n; i++) {
            fathers[i] = i;
        }
        int count = 0;// 定义岛屿数量
        // 遍历每个新加的位置
        for(int[] position : positions) {
            int i = position[0];
            int j = position[1];
            if (grid[i][j] == 1) {// 如果新加的这个位置已经是陆地的话，则count++
                res.add(count);// 这里是因为测试用例中会给重复的陆地坐标,重复的陆地坐标不重复计算
                continue;// 转到下一个位置
            }
            // 新加位置不是陆地,则先置为陆地,然后判断是否与周围的已有陆地构成岛屿
            // 若与已有陆地构成岛屿,则count-1
            grid[i][j] = 1;
            count ++;
            int cur_pos = i * n + j;
            if (i > 0 && grid[i - 1][j] == 1) {// 上面位置为陆地
                if(union(cur_pos, cur_pos - n))
                    count --;// 如果当前新加的陆地与之前的陆地构成岛屿就count-1
            }
            if (j > 0 && grid[i][j - 1] == 1) {
                if (union(cur_pos, cur_pos - 1))
                    count --;
            }
            // 岛屿数量1中不用考虑向右和向下搜索,因为陆地位置时固定的,直接按顺序遍历grid即可
            // 岛屿2每个陆地位置是随机给的,有的测试用例就会先给大的坐标,再给小的坐标
            // 所以必须要四个方向都考虑
            if (i < m - 1 && grid[i + 1][j] == 1) {
                if (union(cur_pos, cur_pos + n))
                    count --;
            }
            if (j < n - 1 && grid[i][j + 1] == 1) {
                if (union(cur_pos, cur_pos + 1))
                    count --;
            }
            res.add(count);
        }
        return res;
    }

    private boolean union(int i, int j) {
        int f1 = find(i);
        int f2 = find(j);
        if (f1 == f2)
            return false;
        fathers[f1] = f2;
        return true;
    }

    private int find(int i) {
        while (fathers[i] != i)
            i = fathers[i];
        return i;
    }
}
