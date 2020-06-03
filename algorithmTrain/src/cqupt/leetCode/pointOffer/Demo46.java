package cqupt.leetCode.pointOffer;

import java.util.ArrayList;

/**
 * @author yiLi
 * @create 2020-06-03 16:16
 */
public class Demo46 {
    public static int translateNum(int num) {
        if (num == 0)
            return 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (num > 0) {
            list.add(num % 10);
            num /= 10;
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(list.size() - i - 1);
        }
        int[] dp = new int[list.size() + 1];
        dp[0] = 1;
        dp[1] = 1;// 只包含第一个数字的情况
        for (int i = 2; i < dp.length; i++) {
            int cur = arr[i - 2] * 10 + arr[i - 1];
            if (arr[i - 2] != 0 && (cur <= 25 && cur >= 0))
                dp[i] = dp[i - 1] + dp[i - 2];
            else
                dp[i] = dp[i -1];
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}
