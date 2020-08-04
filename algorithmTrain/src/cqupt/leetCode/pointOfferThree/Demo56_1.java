package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-08-04 17:17
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 * 除了两个数字外其他数字都出现了两次
 * 需要判断数组中0的个数
 */
public class Demo56_1 {
    public int[] singleNumbers(int[] nums) {
        int zeroCount = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            if (num == 0)
                zeroCount ++;
            sum ^= num;
        }
        if (zeroCount == 1)
            return new int[]{0, sum};
        // 至此0出现了0次或者2次
        int l = min;
        int r = max;
        while (l <= r) {
            int leftSum = 0;
            int rightSum = 0;
            int mid = l + (r - l) / 2;
//            for (int i = l; i <= mid; i++) {
//                leftSum += nums[i];
//            }
//            for (int i = mid + 1; i <= r; i++) {
//                rightSum += nums[i];
//            }
            for (int num : nums) {
                if (num <= mid)
                    leftSum ^= num;
                else
                    rightSum ^= num;
            }
            if (leftSum != 0 && rightSum != 0)
                return new int[]{leftSum, rightSum};
            if (leftSum != 0) {
                r = mid - 1;
            }else if (rightSum != 0)
                l = mid + 1;
        }
        return null;
    }
}
