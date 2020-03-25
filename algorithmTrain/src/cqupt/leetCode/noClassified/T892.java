package cqupt.leetCode.noClassified;

/**
 * @author Liyi
 * @create 2020-03-25 11:19
 * 加减法问题
 * 位运算优先级在加减之下
 */
public class T892 {
    public static int surfaceArea(int[][] grid) {
        // 考虑每个柱体,不是简单的考虑每个小方块
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int curLevel = grid[i][j];
                if (curLevel > 0) {
                    area += (curLevel << 2) + 2;// 每个柱体提供的表面积是小方块数*4+2(柱体的上下底)
                    if (i > 0 && grid[i - 1][j] > 0)// 只需要看i-1而不用看i+1,因为for是从前往后遍历的
                        area -= Math.min(curLevel, grid[i - 1][j]) << 1;// 如果有两个柱体贴合,重叠的面积就是二者高的最小值*2
                    if (j > 0 && grid[i][j - 1] > 0)
                        area -= Math.min(curLevel, grid[i][j - 1]) << 1;
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = {{2}};
        int area = surfaceArea(grid);
        System.out.println(area);
    }
}
