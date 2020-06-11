package cqupt.leetCode.pointOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yiLi
 * @create 2020-06-10 9:13
 */
public class Demo56_2_todo {
    public static int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num,1);
            else
                map.put(num, map.get(num) + 1);
        }
        for(Map.Entry entry :map.entrySet()) {
            if (entry.getValue().equals(1))
                return (int) entry.getKey();
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{9,2,7,9,7,9,7}));
    }
}
