package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-05 22:30
 * 旋转图像
 */
public class T48 {



    public void rotate(int[][] matrix) {
        if (null == matrix || matrix.length == 0 || matrix[0].length == 0)
            return;
        int left = 0;
        int right = matrix.length - 1;
        int top = 0;
        int buttom = matrix.length - 1;
        int n = matrix.length;
        while (n > 1) {// n表示n*n矩阵
            for (int i = 0; i < n - 1; i++) {// 一圈分四组 每组n-1个元素
                // 画图很容易看出来关系
                int temp = matrix[top][left +i];
                matrix[top][left +i] = matrix[buttom - i][left];
                matrix[buttom - i][left] = matrix[buttom][right - i];
                matrix[buttom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }
            // 外层转完，向内层推进
            left += 1;
            top += 1;
            right -= 1;
            buttom -= 1;
            n -= 2;
        }
    }
}
