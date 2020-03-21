package cqupt.leetCode.twoPointer;

import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-03-21 16:17
 * 有效的三角形---三指针,本题不用去重
 */
public class T611 {
    public int triangleNumber(int[] nums) {
        // 需要先对数组排序,但是不需要去重
        int res = 0;
        int n = nums.length;
        Arrays.sort(nums);
        // i,j两个指针每到一个新位置.构成一个新的循环,此时k都从数组最后一个元素开始往前走
        // 当遇到nums[i]+nums[j]>nums[k](构成三角形),就返回k-j个结果(相对于i,j固定,k在动的大循环中)
        // 因为数组事先排序了,所以满足三角形条件时,k-1位置元素也是满足三角形条件的,所以直接返回k-j,然后更换i,j位置
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int k = n - 1;
                while (j < k) {
                    if (nums[i] + nums[j] > nums[k]) {
                        res += k - j;
                        break;
                    }else {
                        k --;
                    }
                }
            }
        }
        return res;
    }
}
