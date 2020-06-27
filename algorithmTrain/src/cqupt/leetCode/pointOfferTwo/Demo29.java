package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-27 9:38
 * 顺时针打印矩阵
 */
public class Demo29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[]{};
        }
        int[] res = new int[matrix.length * matrix[0].length];
        int t = 0;
        int b = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        int index = 0;
        while (index < res.length) {
            int ll = l;
            while (ll <= r) {
                res[index ++] = matrix[t][ll ++];
            }
            if (index == res.length)// 可能在外层while的内部执行过程中发生越界
                break;
            t ++;
            int tt = t;
            while (tt <= b) {
                res[index ++] = matrix[tt++][r];
            }
            if (index == res.length)
                break;
            r --;
            int rr = r;
            while (rr >= l) {
                res[index ++] = matrix[b][rr --];
            }
            if (index == res.length)
                break;
            b --;
            int bb = b;
            while (bb >= t) {
                res[index ++] = matrix[bb --][l];
            }
            if (index == res.length)
                break;
            l ++;
        }
        return res;
    }
}
