package cqupt.leetCode.pointOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yiLi
 * @create 2020-06-02 10:41
 */
public class Demo39_impor {
    public int majorityElement1(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            }else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (nums.length / 2))
                return entry.getKey();
        }
        return -1;
    }
    // 摩尔投票法
    // 众数的数量大于非众数数量累加和
    public int majorityElement(int[] nums) {
        int x = 0;
        int votes = 0;
        for(int num : nums) {
            if (votes == 0)
                x = num;// 当票数为0的时候,这时候num就假定为众数
            votes += x == num ? 1 : -1;// 不断清零前面的票数累计和,最终为众数那个数一定是数量过半的
        }
        return x;
    }
}
