package cqupt.writtenExamination.smallRedBook;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-30 19:24
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        int[][] grid = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        boolean[] visitedR = new boolean[r];
//        helper(0, new ArrayList<Integer>());
        System.out.println(4);
    }

    private static void helper(int index, ArrayList<Integer> curList) {
        if (index == n)
            return;
        if (curList.size() == r) {
            resR.add(new ArrayList<>(curList));
        }else {
            helper(index + 1, curList);
            curList.add(index);
//            visitedR[index] = true;
            helper(index + 1, curList);
            curList.add(curList.size() - 1);
//            visitedR[index] = false;
        }
    }


    static List<ArrayList<Integer>> resR;
    static int n, m, r, c;
}
