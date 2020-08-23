package cqupt.leetCode.pointOfferThree;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-08-17 9:36
 * 有重复元素的全排列
 */
public class Main3 {
    private List<List> RES;
    public List<List> permuteUnique(int[] nums) {
        RES = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return RES;
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        helper(nums, 0, visited, nums.length, new ArrayList<Integer>());
        return RES;
    }

    private void helper(int[] nums, int index, boolean[] visited, int n, ArrayList<Integer> curList) {
        if (index == n) {
            RES.add(new ArrayList(curList));
        }else {
            for (int i = 0; i < nums.length; i++) {// 从nums数组中选出index位置的元素
                if (!visited[i] && (i == 0 || nums[i - 1] != nums[i] || visited[i - 1])) {
                    visited[i] = true;
                    curList.add(nums[i]);
                    helper(nums, index + 1, visited, n, curList);
                    visited[i] = false;
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        String s = "123";
//        int num = Integer.parseInt(s);
//        char[] ch = new char[1];
//        String s1 = String.valueOf(ch);
//        System.out.println(num);
        byte[] buff = new byte[10];
        int count = System.in.read(buff);
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.println("," + buff[i]);

        }
    }
}
