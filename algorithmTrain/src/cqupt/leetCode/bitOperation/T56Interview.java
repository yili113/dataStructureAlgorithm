package cqupt.leetCode.bitOperation;

import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-04-28 16:11
 */

public class T56Interview {
    /**
     * 异或：相同为0,不同为1
     * 对一串数字进行异或和,假定里面除了1个数字外,其余数字都是成对的,那么最终的异或和结果就是那个单独的数字(相同的数字异或为0)
     * 使用二分,来找数组中两个单独的数字,选取mid,判断两个数组中的异或和是否不为0,均不为0的话两个异或和就是最终答案
     * mid不满足要求的话就继续找mid
     * @param nums
     * @return
     */
    public static int[] singleNumbers(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int zerosCount = 0;
        for(int num : nums) {
            if (num == 0)
                zerosCount ++;
            min = Math.min(min, num);
            max = Math.max(max, num);
            sum ^= num;// 求原数组的异或和
        }
        // 判断数组中0的情况
        // 如果数组中只有一个0,那次数为1的两个数一定是0和最终的异或和
        if (zerosCount == 1)
            return new int[]{0, sum};
        int left = min;
        int right = max;
        while (left <= right) {
            int mid = left < 0 ? (left + right) >> 1 : left + (right - left) / 2;
            // 求两个数组的异或和
            int leftSum = 0;
            int rightSum = 0;
            for(int num : nums) {
                if (num <= mid)
                    leftSum ^= num;
                else
                    rightSum ^= num;
            }
                // 判断当前的mid是否符合要求
                // 也就是判断两个数组的异或和是否都不等于0
                // 1.两个数分别落在两个数组中,此时mid是正合适的
                if (leftSum != 0 && rightSum != 0)
                    return new int[]{leftSum, rightSum};
                // 2.表示选的mid过小,两个数都落在右边数组中
                if (leftSum == 0)
                    left = mid;
                // 3.表示mid过大
                else
                    right = mid;
        }
        return null;
    }



    public static void main(String[] args) {
        int[] nums = {4,1,4,6};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }
}
