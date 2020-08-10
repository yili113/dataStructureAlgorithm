package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-08-08 13:44
 */
public class packet01 {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};
        int[] val = {1500, 3000, 2000};
        int total = 4;
        System.out.println(getMaxVal(total, w, val));
    }

    private static int getMaxVal(int total, int[] w, int[] val) {
        int n = w.length;
        int[][] dp = new int[n + 1][total + 1];// 横轴表示商品种类,纵轴表示背包的容量
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;// 表示背包容量为0时候的最大价值
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;// 表示不装商品时候最大价值
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {// j表示当前重量  1-total
                if (j < w[i- 1]) {// 当前背包重量没法装当前物品,价值就是 前i-1件商品容量为j 的最大价值
                    dp[i][j] = dp[i - 1][j];
                }else if (j >= w[i - 1]) {
                    // 两种情况取最大值：
                    // 1.不选当前物品
                    // 2.选当前物品  就要先用j-w[当前物品]得到当前背包可用的容量
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - w[i - 1]]);
                }
            }
        }
        return dp[n][total];
    }
}
