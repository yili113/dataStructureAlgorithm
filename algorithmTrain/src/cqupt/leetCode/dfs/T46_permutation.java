package cqupt.leetCode.dfs;

import java.util.*;

/**
 * @author Liyi
 * @create 2020-03-05 16:22
 * 全排列
 */

public class T46_permutation {


    /**
     * 数组中没有重复的元素
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        permuteHelper(result, new LinkedList<Integer>(), nums, new HashSet<Integer>());
        return result;
    }

    private void permuteHelper(ArrayList<List<Integer>> result, LinkedList<Integer> curList, int[] nums, HashSet<Integer> hashSet) {
        // 出口
        if (curList.size() == nums.length) {
            result.add(new LinkedList<Integer>(curList));// 此处不用写return  因为递归体里面不是if  就是else
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (!hashSet.contains(nums[i])) {
                    hashSet.add(nums[i]);
                    curList.add(nums[i]);
                    permuteHelper(result, curList, nums, hashSet);// 此处不用索引是因为每次递归都要从都头开始判断 重新走一遍for循环
                    // 这里用hashSet标记元素是否被访问过
                    hashSet.remove(nums[i]);// 回溯
                    curList.remove(curList.size() - 1);// 回溯
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,3};
        T46_permutation t46Permutation = new T46_permutation();
        List<List<Integer>> lists = t46Permutation.permute(nums);
        List<List<Integer>> lists1 = t46Permutation.permuteUnique(nums);
//        List<List<Integer>> lists2 = t46Permutation.permuteUnique1(nums);
        System.out.println(lists1);
    }

    public List<List<Integer>> permuteUnique1(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return results;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(results, new ArrayList<Integer>(), 0, visited, nums);
        return results;
    }

    private void dfs(ArrayList<List<Integer>> results, ArrayList<Integer> cur, int index, boolean[] visited, int[] nums) {
        if (index == nums.length) {
            results.add(new ArrayList<>(cur));
            return;
        }else {
            // 需要为cur的index位置选值，从nums中第一个到最后一个数中选  cur的长度和nums长度一样
            for (int i = 0; i < nums.length; i++) {
                // 选的话还有条件
                if (!visited[i] && (index == 0 || visited[index - 1] != visited[index] || visited[i - 1])) {
                    cur.add(nums[i]);
                    visited[i] = true;
                    dfs(results, cur, index + 1, visited, nums);
                    visited[i] = false;
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }

    /**
     * 数组中允许有重复的元素，但是返回的结果中不能有重复的集合
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return results;
        Arrays.sort(nums);// 先排序，数组中有重复元素。排序后便于写判断逻辑避免最终的结果有重复的集合
        permuteUniqueHelper(results, new LinkedList<Integer>(), new boolean[nums.length], nums);
        return results;
    }
    // 这里不能用hashSet表示元素是否被访问过 因为这里允许重复的元素 只能用boolean数组
    private void permuteUniqueHelper(ArrayList<List<Integer>> results, LinkedList<Integer> curList, boolean[] used, int[] nums) {
        if (curList.size() == nums.length)
            results.add(new LinkedList<>(curList));
        else {
            int preNum = nums[0] - 1;// 表示数组第一个数前面那个数   nums[0]-1比nums中所有数都要小
            // nums[0] - 1最开始的preNum 每一层的preNum都会改变
            for (int i = 0; i < nums.length; i++) {
                // 只需要判断跟前面那个数是否相同 不用考虑跟后面的数是否相同 假如说有 222  肯定用第一个2
                if (!used[i] && nums[i] != preNum) {// 当前元素没有访问过并且和前面那个数不重复
                    preNum = nums[i];
                    curList.add(nums[i]);
                    used[i] = true;
                    permuteUniqueHelper(results, curList, used, nums);
                    used[i] = false;
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }
}

