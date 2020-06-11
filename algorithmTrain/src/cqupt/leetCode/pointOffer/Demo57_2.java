package cqupt.leetCode.pointOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-10 10:07
 */
public class Demo57_2 {
    private static ArrayList<ArrayList<Integer>> RES;
    // 反过来找
    public static ArrayList<ArrayList<Integer>> findContinuousSequence1(int target) {
        for (int i = target / 2 + 1; i > 0 ; i--) {
            helper(new ArrayList<Integer>(), target, i, 0);
        }
        return RES;
    }

    private static void helper(ArrayList<Integer> integers, int target, int curNum, int sum) {
        if (curNum < 1 || sum > target)
            return;
        if (sum == target && integers.size() >= 2) {
            RES.add(new ArrayList<>(integers));
            return;
        }
        // 把当前的数加进来
        sum += curNum;
        integers.add(curNum);
        helper(integers, target, curNum - 1, sum);
        sum -= curNum;
        integers.remove(integers.size() - 1);
    }

    public static void main(String[] args) {
        int[][] res = findContinuousSequence(15);
        for (int[] arr : res) {
            System.out.println(Arrays.toString(arr));
        }
    }
    private static ArrayList<int[]> res = new ArrayList<>();
    public static int[][] findContinuousSequence(int target) {
        int l = 1;
        int r = 1;
        int sum = 0;
        while (l <= target / 2) {
            if (sum < target) {
                sum += r;
                r ++;
            }else if (sum > target) {
                sum -= l;
                l ++;
            }else {
                int[] arr = new int[r - l];// 左闭右开
                for (int k = l; k < r; k++) {
                    arr[k - l] = k;
                }
                res.add(arr);
                sum -= l;
                l ++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
