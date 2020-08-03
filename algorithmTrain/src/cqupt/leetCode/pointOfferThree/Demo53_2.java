package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-08-03 10:16
 * 0-(n-1)中丢失的数字
 */
public class Demo53_2 {
    public int missingNumber(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            if (nums[mid] == mid) {// 说明缺失的元素在mid右侧
                l = mid + 1;
            }else {
                r = mid - 1;// 只要不等就说明缺失元素在mid左侧   因为不可能mid<nums[mid]
            }
        }
        return l;
    }
}
