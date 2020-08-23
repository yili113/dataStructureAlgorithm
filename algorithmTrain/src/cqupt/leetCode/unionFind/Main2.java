package cqupt.leetCode.unionFind;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-22 15:57
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] orders = new int[n][3];
        for (int i = 0; i < n; i++) {
            orders[i][0] = sc.nextInt();
            orders[i][1] = sc.nextInt();
            orders[i][2] = i + 1;

        }
        sc.close();
        Arrays.sort(orders, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o2[0] + 2 * o2[1]) - (o1[0] + 2 * o1[1]);
            }
        });
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            res[i] = orders[i][2];

        }
        Arrays.sort(res);
        for (int i = 0; i < m; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
