package cqupt.leetCode.pointOffer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-03 15:32
 */
public class Demo45_impor {
    private String RES = String.valueOf(Integer.MAX_VALUE);
    public String minNumber1(int[] nums) {
        if (nums == null || nums.length == 0)
            return String.valueOf(RES);
        boolean[] visited = new boolean[nums.length];

        helper(nums, 0, visited, new ArrayList<Integer>());
        return String.valueOf(RES);
    }

    private void helper(int[] nums, int index, boolean[] visited, ArrayList<Integer> curList) {
        if (index == nums.length) {
            String str = "";
            for (int i = 0; i < curList.size(); i++) {
                str += curList.get(i);
            }
            BigInteger b = new BigInteger(str);
            BigInteger res = new BigInteger(RES);
            RES = Integer.parseInt(str) < Integer.parseInt(RES) ? str : RES;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curList.add(nums[i]);
                helper(nums, index + 1, visited, curList);
                visited[i] = false;
                curList.remove(curList.size() - 1);
            }
        }
    }
    // x = 3  y = 30
    // 如果 x+y > y+x  则是330
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i] + "";
        }
        Arrays.sort(strs, (x, y) -> (x + y).compareTo(y + x));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.length; i++) {
            sb.append(strs[i]);
        }
        return new String(sb);
    }
}
