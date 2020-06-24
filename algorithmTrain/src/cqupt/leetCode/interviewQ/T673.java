package cqupt.leetCode.interviewQ;

/**
 * @author yiLi
 * @create 2020-06-21 16:19
 */
public class T673 {
    // 返回最长递增子序列的长度即可
    public static int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;// 初始化为1
        }
//        for (int i = 1; i < n; i++) {
//            if (nums[i] > nums[i - 1])
//                dp[i] = dp[i - 1] + 1;
//            else {
//                for (int j = i - 1; j >= 0; j--) {// 防止越界
//                    if (nums[j] < nums[i]) {
//                        dp[i] = dp[j] + 1;
//                        break;
//                    }
//                }
//                dp[i] = dp[i] == 0 ? 1 : dp[i];
//            }
//        }
        for (int i = 1; i < n; i++) {
            int maxDp = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxDp = dp[j] > maxDp ? dp[j] : maxDp;
                }
            }
            dp[i] = maxDp + 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5229,3259,6695,5593,9600,314,4340,9644,849,3232};
//        int[] nums = {1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));
    }
}
