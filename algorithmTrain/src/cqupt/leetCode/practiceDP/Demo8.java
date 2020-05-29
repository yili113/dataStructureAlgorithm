package cqupt.leetCode.practiceDP;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yiLi
 * @create 2020-05-29 10:48
 */
public class Demo8 {
    public int getMaxNum(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        Envelope[] envelopes = new Envelope[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            envelopes[i] = new Envelope(matrix[i][0], matrix[i][1]);
        }
        Arrays.sort(envelopes, new Com());// 将所有信封按照长递增排序  如果长度相等的信封按照宽度递减
        int[] arr = new int[matrix.length];// 把排序好的宽度放进去
        for (int i = 0; i < arr.length; i++) {
            arr[i] = envelopes[i].width;
        }
        int[] dp = getDp(arr);// 根据宽度序列得到dp序列
        int[] res = getMax(arr, dp);
        return res.length;
    }

    private int[] getMax(int[] arr, int[] dp) {
        int len = 0;
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > len) {
                len = dp[i];
                index = i;
            }
        }
        int[] res = new int[len];
        res[--len] = arr[index];
        for (int i = index - 1; i >= 0; i--) {
            if (arr[index] > arr[i] && dp[index] == dp[i] + 1) {
                res[--len] = arr[i];
                index = i;
            }
        }
        return res;
    }

    private int[] getDp(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {// 到i-1 判断前面的最长子序列
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        Demo8 demo8 = new Demo8();

        System.out.println(demo8.getMaxNum(new int[][]{{3,4},{2,3},{4,5},{1,3},{2,2},{3,6},{1,2},{3,2},{2,4}}));
    }
}
class Envelope {
    int length;
    int width;

    public Envelope(int length, int width) {
        this.length = length;
        this.width = width;
    }
}
class Com implements Comparator<Envelope> {

    @Override
    public int compare(Envelope o1, Envelope o2) {
        return o1.length != o2.length ? o1.length - o2.length : o2.width - o1.width;
    }
}