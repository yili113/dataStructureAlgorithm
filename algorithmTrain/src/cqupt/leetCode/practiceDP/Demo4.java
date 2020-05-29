package cqupt.leetCode.practiceDP;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-05-27 16:53
 * 换钱的最少货币数
 */
public class Demo4 {
//    int MIN_NUM;
    public int getMinNum(int[] arr, int target) {
        if (arr == null || arr.length == 0 || target < 0)
            return -1;
        Arrays.sort(arr);
        return helper(arr, 0, target, 0);
//        return MIN_NUM;
    }

    private int helper(int[] arr, int index, int target, int minNum) {
        if (target == 0) {
            return minNum;
        }
        for (int i = index; i < arr.length; i++) {
            if (arr[i] > target)
                break;
            minNum ++;
            helper(arr, i, target - arr[index], minNum);
            minNum --;
        }
        return minNum;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3};
        int target = 20;
        Demo4 demo4 = new Demo4();
        System.out.println(demo4.getMinNum(arr,target));
    }
}
