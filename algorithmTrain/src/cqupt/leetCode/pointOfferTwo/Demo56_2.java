package cqupt.leetCode.pointOfferTwo;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-07-03 9:23
 */
public class Demo56_2 {
    // 输入：nums = [3,4,3,3]
    // 输出：4
    // 只有一个数只出现1次 ,其他的出现3次

    // hash表
    public int singleNumber1(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int num : nums) {
            if (map.get(num) == 1)
                return num;
        }
        return -1;
    }
}
