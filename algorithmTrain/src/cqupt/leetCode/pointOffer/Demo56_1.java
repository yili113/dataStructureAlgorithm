package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-10 8:48
 */
public class Demo56_1 {
    public int[] singleNumbers(int[] nums) {
        if (nums == null || nums.length == 0)
            return new int[]{};
        // 先统计数组中0的个数
        int zeroCount = 0;
        int sum = 0;
        // 为了使用二分先找到最大最小值
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zeroCount ++;
            sum ^= nums[i];
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (zeroCount == 1)
            return new int[]{0, sum};
        // 当原数组0的个数为2时
        int l = min;
        int r = max;// l r都是指向元素值,而不是下标,所以mid也是要指具体数值
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            // 统计左右两侧的异或和
            int leftNum = 0;
            int rightNum = 0;
            for (int num : nums) {
                if (num <= mid)
                    leftNum ^= num;
                else
                    rightNum ^= num;
            }
            if (leftNum != 0 && rightNum != 0)
                return new int[]{leftNum, rightNum};
            if (leftNum == 0)
                l = mid;
            else
                r = mid;
        }
        return null;
    }
}
