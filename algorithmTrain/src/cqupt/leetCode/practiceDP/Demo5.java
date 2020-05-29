package cqupt.leetCode.practiceDP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-05-27 17:23
 * 换钱的方法数
 */
public class Demo5 {

    public static ArrayList<List> getMethods(int[] arr, int target) {
        ArrayList<List> lists = new ArrayList<>();
        if (arr == null || arr.length == 0 || target < 0)
            return lists;
        Arrays.sort(arr);
        helper(arr, 0, lists, target, new ArrayList<Integer>());
        return lists;
    }

    public static int getMethods1(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 0)
            return 0;
        return helper1(arr, 0, target);// 从arr的0号位置开始找 凑齐target数值
    }

    private static int helper1(int[] arr, int index, int target) {
        int res = 0;// 当前的结果
        if (index == arr.length) {// 把所有的面值找完了
            res = target == 0 ? 1 : 0;
        }else {
            for (int i = 0; i * arr[index] <= target; i++) {// 当前面值用i张  从0张开始  满足i*arr[index]<=target就行
                res += helper1(arr, index + 1, target - arr[index] * i);
            }
        }
        return res;
    }

    private static void helper(int[] arr, int index, ArrayList<List> lists, int target, ArrayList<Integer> curList) {
        if (target == 0) {
            lists.add(new ArrayList<Integer>(curList));
        }
        for (int i = index; i < arr.length; i++) {
            if (arr[i] > target)
                break;
            curList.add(arr[i]);
            helper(arr, i, lists, target - arr[i], curList);
            curList.remove(curList.size() - 1);
        }
    }
    // dp一代   O(N*aim^2)
    public static int getMethods2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return 0;
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {// 对于一共钱数是0的情况
            dp[i][0] = 1;
        }
        for (int i = 1; i * arr[0] <= aim; i++) {// 对于arr[0]的整倍数地方都是1
            dp[0][i * arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim ; j++) {
                int num = 0;
                for (int k = 0; k * arr[i] <= j ; k++) {// k表示用几个arr[i]钱币,从0开始
                    num += dp[i - 1][j - k * arr[i]];
                }
                dp[i][j] = num;
            }
        }
        return dp[arr.length - 1][aim];
    }
    // dp三代
    public static int getMethods3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return 0;
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {// 对于一共钱数是0的情况
            dp[i][0] = 1;
        }
        for (int i = 1; i * arr[0] <= aim; i++) {// 对于arr[0]的整倍数地方都是1
            dp[0][i * arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim ; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
                // 原本是 dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i]] + dp[i - 1][j - arr[i] * 2] + ...
                // dp[i][j]等于 用0个i钱币,到 k个i钱币  累加和
                // 而 dp[i][j - arr[i]]  也可以分解 dp[i - 1][j - arr[i]] + dp[i - 1][j - arr[i] - arr[i]] + ...+ dp[i - 1][j-arr[i]-k*arr[i]]
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }
    // dp四代  空间压缩  一维数组
    public static int getMethods4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0)
            return 0;
        int[] dp = new int[aim + 1];
        dp[0] = 1;
        // 初始化第一行
        for (int i = 1; i * arr[0] <= aim ; i++) {
            dp[i * arr[0]] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }
        return dp[aim];
    }
    public static void main(String[] args) {
        int[] arr = {5, 10, 25, 1};
        int target = 10;
        ArrayList<List> lists = getMethods(arr, target);
        for(List list : lists) {
            System.out.println(list);
        }
        System.out.println(getMethods4(arr,target));
    }
}
