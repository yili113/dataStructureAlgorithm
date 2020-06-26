package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-24 14:45
 */
public class Demo11 {
    // 旋转数组的最小数字--- 二分
    // [3,4,5,1,2]
    public static int minArray(int[] numbers) {
        if (numbers == null || numbers.length == 0)
            return -1;
        int l = 0;
        int r = numbers.length - 1;
        while (l < r) {// l<r 就是左闭右开的区间  r的移动就是r=m
            int m = (r - l) / 2 + l;
            if (numbers[m] > numbers[r])// 说明要找的数字在中间值右侧
                l = m + 1;
            else if (numbers[m] < numbers[r])// 说明要找的数字在中间值左侧
                r = m;
            else if (numbers[m] == numbers[r])
                r --;
        }
        return numbers[l];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,0,0,0};
        System.out.println(minArray(nums));
    }
}
