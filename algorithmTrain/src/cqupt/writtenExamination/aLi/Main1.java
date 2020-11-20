package cqupt.writtenExamination.aLi;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-28 16:38
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        StringBuilder s1 = new StringBuilder(sc.nextLine());
        StringBuilder s2 = new StringBuilder(sc.nextLine());
        StringBuilder s2_r = new StringBuilder(s2);
        s2_r.reverse();
        sc.close();
        int s1_count_0 = 0;
        int s2_count_0 = 0;
        int s12_count = 0;
        int s12r_count = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == '0')
                s1_count_0 ++;
            if (s2.charAt(i) == '0')
                s2_count_0 ++;
            if (s1.charAt(i) != s2.charAt(i))
                s12_count ++;
            if (s1.charAt(i) != s2_r.charAt(i))
                s12r_count ++;
        }
    }
    public static int[] reverse(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = arr[n - i - 1];
        }
        return res;
    }
    public static boolean isNeedReverse(int[] a, int[] b) {
        int mid = a.length / 2;
        int n = a.length;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i <= mid; i++) {
            if (a[i] == b[i])
                leftCount ++;
            if (a[i] == b[n - i - 1])
                rightCount ++;
        }
        return rightCount > leftCount;
    }
    public static int getCount(int[] a, int[] b) {
        int n = a.length;
//        int count = 0;
//        for (int i = 0; i < n; i++) {
//            if (a[i] != b[i])
//                count ++;
//        }
//        return count;
        int l1 = 0;
        boolean l1IsZero = false;
        int l2 = 0;
        boolean l2IsZero = false;
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                l1 = i;
                if (a[i] == 0)
                    l1IsZero = true;
            }
        }
        return 0;
    }
}

