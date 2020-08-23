package cqupt.leetCode.pointOfferThree;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-20 20:10
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Res> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Res cur = new Res();
            cur.l = sc.nextInt();
            cur.r = sc.nextInt();
            cur.w = sc.nextInt();
            list.add(cur);
        }
        maxMoney = 0;
        boolean[] visited = new boolean[list.size()];
        helper(list, 0, visited);
    }

    private static void helper(ArrayList<Res> list, int index, boolean[] visited) {
    }

    private static int maxMoney;
    private static int lastTiem;
}
class Res {
    int l;
    int r;
    int w;
}
