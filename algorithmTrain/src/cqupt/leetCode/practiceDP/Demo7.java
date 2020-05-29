package cqupt.leetCode.practiceDP;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-05-29 9:31
 * 最长递增子序列
 */
public class Demo7 {

    public static int[] getMaxList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;
        int[] dp = getDp(arr);
        return getList(arr, dp);
    }

    private static int[] getList(int[] arr, int[] dp) {
        // 先找到dp数组中大的值 作为新数组的长度
        int len = 0;
        int index = 0;// 原数组的索引
        for (int i = 0; i < dp.length; i++) {
//            len = dp[i] > len ? dp[i] : len;
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] res = new int[len];
//        res[len - 1] = arr[index]; // TODO
//        len --;
        res[--len] = arr[index];
        // index始终指向要被放进res数组的下标(arr原数组的下标)
        for (int i = index - 1; i >= 0 ; i--) {// 往前找
            if (dp[i] + 1 == dp[index] && arr[i] < arr[index]) {
//                res[len] = arr[i];
//                len --;
                res[--len] = arr[i];
                index = i;
            }
        }
        return res;
    }
    // dp[i]表示包含当前的arr[i]下最大的递增数列的长度是多少
    // O(N^2)
    private static int[] getDp(int[] arr) {
        int N = arr.length;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {// i前面任何一个比arr[i]小的数都能作为倒数第二个数
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaxList(new int[]{2, 1,5,3,6,4,8,9,7})));
    }
}
