package cqupt.leetCode.dp;

/**
 * @author yiLi
 * @create 2020-05-19 21:17
 */
public class T198 {
    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int pre1 = 0;
        int pre2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

}
