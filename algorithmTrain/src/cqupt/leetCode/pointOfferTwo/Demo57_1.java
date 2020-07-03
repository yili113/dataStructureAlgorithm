package cqupt.leetCode.pointOfferTwo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-07-03 9:51
 * 和为s的两个数
 */
public class Demo57_1 {
    // 输入：nums = [2,7,11,15], target = 9
    // 输出：[2,7] 或者 [7,2]

    // dfs去做
    public static int[] twoSum1(int[] nums, int target) {
        list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(nums, 0, target, visited, new ArrayList<Integer>());
        // 此种方式太麻烦了,只需要取两个数
        int[] res = new int[list.get(0).size()];
        for (int i = 0; i < list.get(0).size(); i++) {
            res[i] = list.get(0).get(i);
        }
        return res;
    }

    private static void helper(int[] nums, int index, int target, boolean[] visited, ArrayList<Integer> curList) {
        if (target == 0) {
            list.add(new ArrayList<>(curList));
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    curList.add(nums[i]);
                    visited[i] = true;
                    helper(nums,index,target - nums[i], visited, curList);
                    curList.remove(curList.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) {
        // [16,16,18,24,30,32]
        //48

        // [10,18,25,33,36,50,50,52,57,74]
        //126
        int[] nums = {10,18,25,33,36,50,50,52,57,74};
        int target = 126;
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }


    // 二分查找的方式  有序数组
    public static int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 2; i++) {
            res[0] = nums[i];
            int l = i + 1;
            int r = nums.length - 1;
            int temp = target - nums[i];
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (nums[mid] == temp) {
                    res[1] = nums[mid];
                    break;
                }else if (nums[mid] > temp) {// 需要找得剩下值在mid左侧
                    r = mid - 1;
                }else if (nums[mid] < temp)
                    l = mid + 1;
            }
            if (res[0] + res[1] == target)
                break;
        }
        return res;
    }
    // 双指针
    public static int[] twoSum3(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] + nums[r] == target)
                return new int[]{nums[l], nums[r]};
            else if (nums[l] + nums[r] > target)
                r --;
            else if (nums[l] + nums[r] < target)
                l ++;
        }
        return null;
    }
}
