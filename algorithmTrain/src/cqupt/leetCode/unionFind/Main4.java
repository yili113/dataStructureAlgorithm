package cqupt.leetCode.unionFind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-22 15:57
 */
public class Main4 {

    private static List<ArrayList<Integer>> ans;
    public static void main(String[] args) {
        ans = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grap = new int[n][n];
        int a = 0;
        int b = 0;
        for (int i = 0; i < n - 1; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            grap[a - 1][b - 1] = 1;
        }
        int[] level = new int[n];
        for (int i = 0; i < n; i++) {
            level[i] = sc.nextInt();
        }
        boolean[] visited = new boolean[n];
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < n; j++) {
                getCount(1, k, grap, level, 0, 0, i,  new ArrayList<Integer>(), j, visited);
            }
        }
        System.out.println(ans.size() + n);
    }

    private static void getCount(int userNum, int k, int[][] grap, int[] level, int maxLevel, int minLevel,
                                 int maxUserNum, ArrayList<Integer> list, int index, boolean[] visited) {
        if (maxLevel - minLevel > k || userNum > maxUserNum || index >= grap.length)
            return;
        if (userNum == maxUserNum)
            ans.add(new ArrayList<>(list));
        int i = index;
        for (int j = 0; j < grap.length; j++) {
            if (grap[i][j] == 1 && !visited[i]) {
                if (userNum == 1) {
                    maxLevel = level[i];
                    minLevel = maxLevel;
                }
                maxLevel = Math.max(maxLevel, level[i]);
                minLevel = Math.min(minLevel, level[i]);
                list.add(i);
                visited[j] = true;
                getCount(userNum + 1, k, grap, level, maxLevel,
                        minLevel,maxUserNum, list, j, visited);
                list.remove(list.size() - 1);
                visited[j] = false;
            }

        }
    }
}
