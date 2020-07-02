package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-02 9:48
 * 0-n-1 中缺失的数字
 */
public class Demo53_2 {
    // 输入: [0,1,2,3,4,5,6,7,9]
    // 输出: 8
    // 利用前n项和
    public static int missingNumber1(int[] nums) {
        int sum = 0;
        int n = nums.length;
        for (int num : nums)
            sum += num;
        int realSum = (1 + n) * n / 2;
        return realSum - sum;
    }
    // 二分查找
    public static int missingNumber2(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == mid)// 缺失的值在mid右侧
                l = mid + 1;
            else if (nums[mid] > mid)// 缺失的值在mid左侧
                r = mid - 1;
        }
        return l;
    }


    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,9};
        System.out.println(missingNumber2(nums));
    }
}
