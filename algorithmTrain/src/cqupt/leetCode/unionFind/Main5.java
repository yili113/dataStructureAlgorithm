package cqupt.leetCode.unionFind;

import java.util.ArrayList;
        import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-22 15:57
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = sc.nextInt();
        int[] nums = new int[x + y + 1];

        for (int i = 1; i <= nums.length - 1; i++) {
            nums[i] = sc.nextInt();
            totalScores += nums[i];
        }
        sc.close();
        boolean[] visited = new boolean[x + y + 1];
        helper(nums, 0, visited, new ArrayList<Integer>());
        System.out.println(maxValue);
    }

    private static void helper(int[] nums, int index, boolean[] visited, ArrayList<Integer> curList) {
        if (index > x) {// 说明A队选完了
            int aAvg = getAScores(curList);
            int aTotal = getAtotal(curList);
            if (aAvg + (totalScores - aTotal) / y > maxValue)
                maxValue = aAvg + (totalScores - aTotal) / y;
            return;
        }else {
            // 不选当前
            helper(nums, index + 1, visited, curList);
            // 选当前
            curList.add(nums[index]);
            helper(nums, index + 1, visited, curList);
            curList.remove(curList.size() - 1);
        }
    }

    private static int getAtotal(ArrayList<Integer> curList) {
        int total = 0;
        for(Integer num : curList)
            total += num;
        return total;
    }

    private static int getAScores(ArrayList<Integer> curList) {
        int total = 0;
        for(Integer num : curList)
            total += num;
        return total / x;
    }

    private static int maxValue = Integer.MIN_VALUE;
    private static int x;
    private static int y;
    private static int totalScores;
}
