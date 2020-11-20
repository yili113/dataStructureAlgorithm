package cqupt.leetCode.twoPointer;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-24 10:00
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] s = new String[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                s[i][j] = sc.next();
            }
        }
//        for (int i = 0; i < n; i++) {
//            int l = Integer.parseInt(s[i][1]);
//            int r = Integer./
//        }

    }
    public static int getLen(String s, int l, int r) {
        int len = r - l + 1;
        int[] res = new int[len];
        int index = 0;
        for (int i = l; i <= r; i++) {
            res[index] = toTen(s, i);
            index ++;;
        }
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
        }
        if (sum % 2 == 0)
            return 0;
        return 1;
    }

    private static int toTen(String s, int i) {
        int res = 0;
        if (i <= 10) {
            int index= 1;
            int t = Integer.parseInt(s);
            while (t > 0) {
                int c = t % 10;
                res+= c * index;
                t /= 10;
                index *= i;
            }
        }else {
            int k = 1;
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(j) >= 'A' && s.charAt(j) <= 'z') {
                    res += (s.charAt(j) - 'A' + 1 + 9) * k;
                }else {
                    res += (s.charAt(j) - '0') * k;
                }
                k *= i;
            }
            return res;
        }
        return res;
    }
}
