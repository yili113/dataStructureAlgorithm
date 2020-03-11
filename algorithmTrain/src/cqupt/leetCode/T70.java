package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-09 11:10
 * 爬梯子----动态规划(一维)
 */
public class T70 {
    /**
     * n个台阶=n-1个台阶时候跨一步+(n-2)个台阶跨两步
     * 所以状态方程   i[n] = i[n-2] + i[n-1];
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] res = new int[n + 1];
        if (n == 0 || n == 1)
            return 1;
        if (n == 2)
            return 2;
        // 初始化
        res[1] = 1;// 只有一个台阶时候一种走法
        res[2] = 2;// 两个台阶时候两种走法
        for (int i = 3; i <= n; i++) {
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[n];
    }

    /**
     * 代码优化：n时候状态只与n-1和n-2时候状态有关
     * @param n
     * @return
     */
    public static int climbStairs1(int n) {
        if (n == 0 || n == 1)
            return 1;
        if (n == 2)
            return 2;
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n ; i++) {
            cur = cur + pre;
            pre = cur - pre;

        }
        return cur;
    }

}
