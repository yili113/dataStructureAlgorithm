package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-03 8:34
 * 数组中数字出现的次数
 * 找只出现一次的数(结果有两个出现一次的数)
 */
public class Demo56_1 {
    // 输入：nums = [4,1,4,6]
    // 输出：[1,6] 或 [6,1]
    public int[] singleNumbers(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;// 求异或和
        int zeroCount = 0;// 统计数组中0的个数
        for (int num : nums) {
            if (num == 0)
                zeroCount ++;
            sum ^= num;
            max = num > max ? num : max;
            min = num < min ? num : min;
        }
        if (zeroCount == 1)
            return new int[]{0, sum};
        // 0出现0次或者2次时候
        int l = min;
        int r = max;
//        int leftSum = 0;// 这个得写在while内部,每次新的l和r有了之后就得更新
//        int rightSum = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int leftSum = 0;
            int rightSum = 0;
            for (int num : nums) {
                if (num < mid)
                    leftSum ^= num;
                else
                    rightSum ^= num;
            }
            if (leftSum != 0 && rightSum != 0)
                return new int[]{leftSum, rightSum};
            if (leftSum != 0)// 说明两个数都在左侧
                r = mid - 1;
            else if (rightSum != 0)
                l = mid + 1;
        }
        return null;
    }
}
