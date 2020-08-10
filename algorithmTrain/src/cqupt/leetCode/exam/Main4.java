package cqupt.leetCode.exam;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-08 14:55
 */
public class Main4 {

    static int maxNum = 100000+10;
    static int[] f = new int[maxNum];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Edge[] edges = new Edge[maxNum];
        for (int i = 1; i <= m; i++) {
            edges[i].u = sc.nextInt();
            edges[i].v = sc.nextInt();
            edges[i].w = sc.nextInt();
        }
        sc.close();
        int flag = 0;
        int res = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

    }
    public static boolean cmp(Edge x, Edge y) {
        return x.w < y.w;
    }
    public static int find(int x) {
        return f[x] == x ? x : find(f[x]);
    }
}
class Edge {
    int u;
    int v;
    int w;
}
