package cqupt.leetCode.interviewQ;

/**
 * @author yiLi
 * @create 2020-06-17 9:42
 * 消失的数字---消失了两个数字
 */
public class Demo17_19 {
    public static int[] missingTwo(int[] nums) {
        int len = nums.length;
        int N = len + 2;// 1-N个数字
        int[] arr = new int[N + len];
        for (int i = 0; i < len; i++) {
            arr[i] = nums[i];
        }
        for (int i = len; i < N + len; i++) {
            arr[i] = i - len + 1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max,num);
        }
        int left = min;
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int leftSum = 0;
            int rightSum = 0;
            for (int num : arr) {
                if (num <= mid)
                    leftSum ^= num;
                else
                    rightSum ^= num;
            }
            if (leftSum != 0 && rightSum != 0)
                return new int[]{leftSum, rightSum};
            if (rightSum != 0)
                left = mid;
            if (leftSum != 0)
                right = mid;
        }
        return null;
    }

}
