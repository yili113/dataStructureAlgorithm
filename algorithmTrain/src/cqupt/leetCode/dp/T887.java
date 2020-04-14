package cqupt.leetCode.dp;

/**
 * @author Liyi
 * @create 2020-04-11 14:17
 * 鸡蛋掉落
 */
public class T887 {

    public int superEggDrop(int K, int N) {
        if(K == 1)
            return N;
        if (N == 1)
            return 1;
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i <= K ; i++) {
            dp[i][1] = 1;
        }
        for (int i = 1; i <= N; i++) {
            dp[1][i] = i;
        }
        for (int i = 2; i <= K ; i++) {
            for (int j = 2; j <= N; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][N - j]) + 1;
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {

    }
}
