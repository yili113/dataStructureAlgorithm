package cqupt.leetCode.practiceDP;

/**
 * @author yiLi
 * @create 2020-05-27 15:44
 * 机器人到达指定位置方法数
 */
public class Demo3 {

    public static int walk(int N, int M, int K, int P) {
        if (N < 1 || M < 1 || M > N || K < 1 || P < 1 || P > N)
            return 0;
        return helper(N, M, K, P);
    }

    private static int helper(int n, int cur, int res, int p) {
        if (res == 0)
            return cur == p ? 1 : 0;
        if (cur == 1)
            return helper(n, 2, res - 1, p);
        if (cur == n)
            return helper(n, n - 1, res - 1, p);
        return helper(n, cur - 1, res - 1, p) + helper(n, cur + 1, res - 1, p);
    }

    public static void main(String[] args) {
        System.out.println(walk1(5, 2, 3, 3));
    }

    public static int walk1(int N, int M, int K, int P) {
        if (N < 2 || M < 1 || M > N || K < 1 || P < 1 || P > N)
            return 0;
        int[][] dp = new int[K + 1][N + 1];
//        for (int i = 1; i <= M ; i++) {
//            if (i == P + 1)
//                dp[0][i] = 1;
//            else
//                dp[0][i] = 0;
//        }
        dp[0][P + 1] = 1;
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][2];
                }else if (j == N) {
                    dp[i][j] = dp[i - 1][N - 1];
                }else {
                    dp[i][j] = dp[i - 1][ j - 1] + dp[i - 1][j + 1];
                }
            }
        }
        return dp[K][M + 1];
    }
}
