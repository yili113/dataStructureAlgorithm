package cqupt.leetCode.unionFind;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-22 15:56
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = sc.next().trim();
        }
        sc.close();
        for (int i = 0; i < n; i++) {
            if (!isNotOk(strs[i]))
                System.out.println("Wrong");
            else
                System.out.println("Accept");
        }
    }

    private static boolean isNotOk(String str) {
        if (str == null || str.length() == 0)
            return false;
        if (!Character.isLetter(str.charAt(0)))
            return false;
        int countLetter = 0;
        int countNum = 0;
        for (int i = 1; i < str.length(); i++) {
            if (!Character.isLetterOrDigit(str.charAt(i)))
                return false;
            if (Character.isLetter(str.charAt(i)))
                countLetter ++;
            if (Character.isDigit(str.charAt(i)))
                countNum ++;
        }
        if (countLetter <= 0 || countNum <= 0)
            return false;
        return true;
    }
}
