package cqupt.writtenExamination.aLi;

import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-28 16:38
 */
public class Main2 {
    private static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        int len = (n + "").length();
        int[] nums = new int[len];
        int index = 0;
        while (n != 0) {
            nums[index ++] = n % 10;
            n /= 10;
        }
        boolean[] visited = new boolean[len];
        Arrays.sort(nums);
        helper(nums, 0, visited, new ArrayList<Integer>(), m);
        System.out.println(count);
    }

    private static void helper(int[] nums, int index, boolean[] visited, ArrayList<Integer> curList, int m) {
        if (index == nums.length) {
            int num = 0;
            for (int i = 0; i < curList.size(); i++) {
                if (curList.get(0) == 0)
                    return;
                num = num * 10 + curList.get(i);
            }
            if (!(num % m == 0))
                return;
            count ++;
        }else {
            for (int i = 0; i < nums.length; i++) {
                if (!visited[i] && (i == 0 || nums[i - 1] != nums[i] || visited[i - 1])) {
                    curList.add(nums[i]);
                    visited[i] = true;
                    helper(nums, index + 1, visited, curList, m);
                    curList.remove(curList.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }
}
