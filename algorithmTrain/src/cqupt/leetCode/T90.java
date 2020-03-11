package cqupt.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-10 9:56
 * 子集2  nums中有重复元素
 */
public class T90 {
    /**
     * 遍历每个元素 分两种情况 当前元素是选还是不选
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(nums == null ||nums.length == 0)
            return res;
        Arrays.sort(nums);// 操作有重复元素的数组时要先排序
        helper(nums, 0, true, res, new LinkedList<Integer>());
        return res;
    }

    /**
     *
     * @param nums
     * @param index
     * @param b 表示上一个元素是取了还是没取     对于index这层递归中的b就是指index-1那层的元素取没取
     * @param res
     * @param curLsit
     */
    private void helper(int[] nums, int index, boolean b, ArrayList<List<Integer>> res, LinkedList<Integer> curLsit) {
        if (index == nums.length)
            res.add(new LinkedList<>(curLsit));
        else {
            // 当前元素不取
            helper(nums, index + 1, false, res, curLsit);
            // 当前元素取
            if (b || nums[index - 1] != nums[index]) {// 如果前后两个元素相同，前者不取后者取的情况下就会造成重复
                curLsit.add(nums[index]);
                helper(nums, index + 1, true, res, curLsit);
                curLsit.remove(curLsit.size() - 1);
            }
        }
    }
}
