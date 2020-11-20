package cqupt.writtenExamination.keDaXunFei;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-29 19:03
 */
public class Main4 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        res = new ArrayList<>();
//        helper(num);
//        StringBuilder sb = new StringBuilder();
//        for(int n : res)
//            sb.append(n).append("*");
//        String string = sb.toString();
//        System.out.println(string.substring(0, string.length() - 1));
//    }
//
//    private static void helper(int num) {
//        if (num == 1) {
//            flag = true;
//            return;
//        }
//        for (int i = 2; i <= 9; i++) {
//            if (num % i == 0) {
//                res.add(i);
//                helper(num / i);
//                if (flag)
//                    return;
//            }
//        }
//    }
//    private static boolean flag;
//    private static ArrayList<Integer> res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String res = helper(num);
        if (res.charAt(res.length() - 1) == '*')
            res = res.substring(0, res.length() - 1);
        System.out.println(res);
    }

    private static String helper(int num) {
        for (int i = 2; i <= 9; i++) {
            if (num % i == 0)
                return i + "*" + helper(num / i);
        }
        return num == 1 ? "" : String.valueOf(num);
    }
}
