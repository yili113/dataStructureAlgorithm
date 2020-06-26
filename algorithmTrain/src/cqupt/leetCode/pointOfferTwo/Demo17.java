package cqupt.leetCode.pointOfferTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-06-26 10:59
 */
public class Demo17 {
    public int[] printNumbers1(int n) {
        int max = 0;
        while (n >= 1) {
            max = max * 10 + 9;
            n --;
        }
        int[] res = new int[max];
        for (int i = 0; i < res.length; i++) {
            res[i] = i + 1;
        }
        return res;
    }
    private static List<ArrayList> res;
    public static List<ArrayList> getPemu(int[] nums) {
        res = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, 0, new ArrayList<>(), visited);
        return res;
    }

    private static void dfs(int[] nums, int index, ArrayList<Object> curList, boolean[] visited) {
        if (index == nums.length)
            res.add(curList);
        for (int i = 0; i < nums.length; i++) {
            if (!visited[nums[i]]) {
                // 从nums中选数字填充到index位置
                curList.add(nums[i]);
                visited[i] = true;
                dfs(nums,index + 1, curList, visited);
                curList.remove(curList.size() - 1);
                visited[i] = false;
            }
        }
    }
}
