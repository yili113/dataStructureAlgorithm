package cqupt.leetCode.pointOffer;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-11 9:33
 */
public class Demo60 {
    public static double[] twoSum1(int n) {
        // n个骰子 一共能出现 n*6-(n-1)种情况
        // 数字分布从 n  --- n*6
        double[] res = new double[n * 6 - (n - 1)];
        // 分母是 6的n次方
//        double fenmu = Math.pow(6, n);
        for (int i = n; i <= n * 6; i++) {
            int cur_count = helper(i, n);// 得到每种情况出现的次数
            res[i - n] = cur_count;
        }
        int totalCount = 0;
        for (double i : res)
            totalCount += i;
        System.out.println(totalCount);
        double[] result = new double[n * 6 - (n - 1)];
        for (int i = 0; i < res.length; i++) {
            result[i] = res[i] / totalCount;
        }
        return result;
    }

    // index 从 1到n遍历   n个位置  每个位置都可以取1-6的数字
    private static int helper(int sum, int n) {
        if (sum < 0)
            return 0;
        if (n == 0 && sum == 0)
            return 1;
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            res += helper(sum - i, n - 1);
        }
        return res;
        //        if (index > n || curNum > sum) {
//            return;
//        }
//        if (curNum == sum) {
//            cur_count ++;
//            return;
//        }
//        for (int i = 1; i <= 6; i++) {// 对当前的index位置进行点数的选择,可以从1选到6
//            curNum += i;
//            helper(index + 1, sum, n, curNum);
//            curNum -= i;
//        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(2)));
    }

    public static double[] twoSum(int n) {
        // n个骰子 一共有6*n中数值情况
        int[][] dp = new int[n + 1][n * 6 + 1];// dp[i][j]表示i个骰子点数和为j的情况数
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {// 遍历每个骰子
            for (int j = 1; j <= i * 6; j++) {// 遍历i个骰子能得到的各种点数和
                for (int k = 1; k <= Math.min(j, 6); k++) {// k表示第i个骰子能掷出的点数  1--6
                    dp[i][j] += dp[i - 1][j - k];// k==1的话就表示第i个骰子掷出1点,剩下的j-1点让前n-1个骰子掷
                }
            }
        }
        int totalCount = 0;
        for (int num : dp[n])
            totalCount += num;
        double[] res = new double[n * 6 - (n - 1)];
        for (int i = 0; i < res.length; i++) {
            res[i] = (double) dp[n][i + n] / totalCount;
        }
        return res;
    }
}