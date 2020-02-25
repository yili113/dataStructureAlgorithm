package cqupt.leetCode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Liyi
 * @create 2020-02-25 10:35
 * T1 两数之和
 */
public class TwoSum {
    /**
     * 使用map存每个数和其对应的下标
     * 每个数都只出现一次 时间复杂度为O(n)
     *
     * 每次遍历nums数组中的值的时候，计算val = target - nums[i]
     * 判断val是否已经在map中了，如果在就直接输出 i 和 val对应的索引
     * 不在的话 就将nums[i],i存到map
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(nums, target)));
    }
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null ||nums.length <= 1)
            return res;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            if (hashMap.containsKey(val)) {
                res[1] = i;
                res[0] = hashMap.get(val);
                return res;
            }else
                hashMap.put(nums[i], i);
        }
        return res;
    }
}
