package cqupt.leetCode.practiceDP;

/**
 * @author yiLi
 * @create 2020-05-28 20:39
 * 打气球的最大分数
 */
public class Demo6 {
    public static int getSocer(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int[] newArr = new int[arr.length + 2];
        newArr[0] = 1;
        newArr[newArr.length - 1] = 1;
        for (int i = 1; i < newArr.length - 1; i++) {
            newArr[i] = arr[i - 1];
        }
        return helper(newArr, 1, newArr.length - 2);
    }
    // 打爆L-R区间内的气球获得最大分数,闭区间
    // L-R 区间外的气球都没被打爆
    public static int helper(int[] arr, int L, int R) {
        if (L == R)
            return arr[L] * arr[L - 1] * arr[L + 1];
        // 最后打爆L位置的
        int socerL = helper(arr,L + 1, R) + arr[L] * arr[L - 1] * arr[R + 1];
        // 最后打爆R位置的
        int socerR = helper(arr, L, R - 1) + arr[R] * arr[R + 1] * arr[L - 1];
        int max = Math.max(socerL, socerR);
        // 最后打爆中间的情况
        for (int i = L + 1; i < R; i++) {
            max = Math.max(max, helper(arr, L, i - 1) + helper(arr, i + 1, R) + arr[i] * arr[L - 1] * arr[R + 1]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(getSocer1(new int[]{3, 2, 5}));
    }

    public static int getSocer1(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int N = arr.length;
        int[] newArr = new int[N + 2];
        newArr[0] = 1;
        newArr[newArr.length - 1] = 1;
        for (int i = 1; i < newArr.length - 1; i++) {
            newArr[i] = arr[i - 1];
        }
        int[][] dp = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {// 填写对角线
            dp[i][i] = newArr[i - 1] * newArr[i] * newArr[i + 1];
        }
        for (int L = N; L >= 1; L--) {
            for (int R = L + 1; R <= N; R++) {
                // 最后打爆最左侧的
                int left = dp[L + 1][R] + newArr[L] * newArr[L - 1] * newArr[R + 1];
                // 最后爆最右侧的
                int right = dp[L][R - 1] + newArr[R] * newArr[L - 1] * newArr[R + 1];
                dp[L][R] = Math.max(left, right);
                for (int i = L + 1; i < R; i++) {
                    dp[L][R] = Math.max(dp[L][R], newArr[i] * newArr[L - 1] * newArr[R + 1] + dp[L][i - 1] + dp[i + 1][R]);
                }
            }
        }
        return dp[1][N];
    }
}
