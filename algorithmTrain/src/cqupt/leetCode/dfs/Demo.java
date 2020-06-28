package cqupt.leetCode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-06-27 21:09
 */
public class Demo {
    ArrayList<List<Integer>> RES;
    public List<List<Integer>> permute(int[] nums) {
        RES = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return RES;
        boolean[] visted = new boolean[nums.length];
        helper(nums, 0, visted, new ArrayList<Integer>());
        return RES;
    }

    private void helper(int[] nums, int index, boolean[] visted, ArrayList<Integer> curList) {
        if (index == nums.length)
            RES.add(new ArrayList<>(curList));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!visted[i]) {
                    curList.add(nums[i]);
                    visted[i] = true;
                    helper(nums,index + 1, visted, curList);
                    curList.remove(curList.size() - 1);
                    visted[i] = false;
                }
            }
        }
    }
}
