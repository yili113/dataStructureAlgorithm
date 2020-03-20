package cqupt.leetCode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-05 11:21
 */
public class T39 {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0 || target <= 0)
            return results;
        Arrays.sort(candidates);// 需要排序
        combinationSumHelper(candidates, target, 0, results, new ArrayList<Integer>());
        return results;
    }

    /**
     *
     * @param candidates
     * @param target 还能放进去的target值 每次都会减少 直到0
     * @param index 将要操作的数组下标  index=0表示尝试判断candidates[0]能否加入
     * @param results
     * @param curList 每一层都会有一个curList记录上一层已经放进去的元素值
     */
    private void combinationSumHelper(int[] candidates, int target, int index, ArrayList<List<Integer>> results,
                                      ArrayList<Integer> curList) {
        if (target == 0)// 出口
            // 此处操作是将当前满足条件的的list放进results中
            // 还要将curList复制一下，后面回溯会把curList改变掉
            // 只需要存当前符合条件的curList
            results.add(new ArrayList<Integer>(curList));
        else if (target > 0) {// 还能继续添加
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] > target) break;
                if (i != index && candidates[i] == candidates[i - 1])
                    continue;
                curList.add(candidates[i]);// 先把candidates[i]装进curList试一下
                /**
                 * 再进递归 index还是从i开始不是从i+1体现了元素可以重复用
                 * {2,3,6,7} 找7   若i+1则返回[[7]]   若i则返回[[2,2,3],[7]]
                 */
                combinationSumHelper(candidates, target - candidates[i], i, results, curList);
                curList.remove(curList.size() - 1);// 回溯

                // 回溯
                /**
                 * 1.先加进去
                 * 2.做结果
                 * 3.再拿掉
                 */
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        T39 t39 = new T39();
        List<List<Integer>> lists = t39.combinationSum(candidates, target);
        System.out.println(lists);

    }
}
