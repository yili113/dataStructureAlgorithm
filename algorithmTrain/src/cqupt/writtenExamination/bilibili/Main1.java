package cqupt.writtenExamination.bilibili;

/**
 * @author yiLi
 * @create 2020-09-04 19:03
 * 最长连续子数组
 * 给定一个由若干0和1组成的数组A，我们最多可以将K个值从0换成1，返回仅包含1的最长连续子数组的长度
 * 输入：int[] arr = {1,1,1,0,0,0,1,1,1,1,0};   int k = 2;
 * 输出：6
 */
public class Main1 {
    public static int GetMaxConsecutiveOnes (int[] arr, int k) {
        // write code here
//        if (arr == null || arr.length == 0)
//            return 0;
//        int len = arr.length;
//        int max = Integer.MIN_VALUE;
//        int curK = k;
//        int left = 0;
//        int right = 0;
//        while (right < len) {
//            if (arr[right] == 1) {
//                right ++;
//            }else if (arr[right] == 0 && curK > 0) {
//                right ++;
//                curK --;
//            }else if (arr[right] == 0 && curK <= 0) {
//                max = Math.max(max, right - left);
//                left = right - k;
//                right = left;
//                curK = k;
//            }
//        }
//        return max;
        int max = Integer.MIN_VALUE;
        int curLen = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;
        while (right != arr.length) {
            if (arr[right ++] == 0)
                zeros ++;
            while (zeros > k) {
                if (arr[left ++] == 0)
                    -- zeros;
            }
            curLen = right - left;
            max = Math.max(curLen, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(GetMaxConsecutiveOnes(arr, k));
    }
}
