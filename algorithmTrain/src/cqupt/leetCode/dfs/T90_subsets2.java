package cqupt.leetCode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-10 9:56
 * 子集2  nums中有重复元素
 */
public class T90_subsets2 {
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
            // 当前元素取  下面这个b为true是表示前一个选了
            if (b || nums[index - 1] != nums[index]) {// 如果前后两个元素相同，前者不取后者取的情况下就会造成重复
                curLsit.add(nums[index]);
                helper(nums, index + 1, true, res, curLsit);
                curLsit.remove(curLsit.size() - 1);
            }
        }
    }


    public List<List<Integer>> subsetsWithDup1(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(result, new ArrayList<Integer>(), 0, nums, visited);
        return result;
    }

    private void dfs(ArrayList<List<Integer>> result, ArrayList<Integer> cur, int index, int[] nums, boolean[] visited) {
        if (index == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        else {
            // 不选
            dfs(result, cur, index + 1, nums, visited);
            // 选
            // if中的||关系 要分清前后 很重要
            if (index == 0 || nums[index - 1] != nums[index] || visited[index - 1]) {// 相同元素放在一起只有前面选了后面才能选
                cur.add(nums[index]);
                visited[index] = true;
                dfs(result, cur, index + 1, nums, visited);
                visited[index] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }
}
