package cqupt.leetCode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-06-27 21:20
 */
public class Demo1 {
    ArrayList<List<Integer>> RES;
    public List<List<Integer>> permuteUnique(int[] nums) {
        RES = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return RES;
        boolean[] visted = new boolean[nums.length];
        Arrays.sort(nums);
        helper(nums, 0, visted, new ArrayList<Integer>());
        return RES;
    }

    private void helper(int[] nums, int index, boolean[] visted, ArrayList<Integer> curList) {
        if (index == nums.length)
            RES.add(new ArrayList<>(curList));
        else {
            for (int i = 0; i < nums.length; i++) {
                // nums[i]能选上的条件：
                // 1.nums[i]的visited为false
                // 2.要么是nums的第一个元素,要么其前一个元素跟当前元素不同
                // 要么前面元素跟当前元素相同,但是前面相同的元素选了,这样当前元素也是可选的
                if (!visted[i] && (i == 0 || nums[i - 1] != nums[i] || visted[i - 1])) {
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
