package cqupt.writtenExamination.xiaoMI;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-09-08 18:30
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] strs = in.split(" ");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(getRes(strs[i]));
        }
    }

    private static int getRes(String str) {
        if (str.length() < 8 || str.length() > 120)
            return 1;
        char[] chars = str.toCharArray();
        boolean isLetterA = false;
        boolean isDigit = false;
        boolean isLettera = false;
        boolean isFuHao = false;
        for(char ch : chars) {
            if (!Character.isLetterOrDigit(ch)) {
                isFuHao = true;
            }else if (Character.isDigit(ch)) {
                isDigit = true;
            }else if (Character.isLowerCase(ch)) {
                isLettera = true;
            }else if (!Character.isLowerCase(ch)) {
                isLetterA = true;
            }
        }
        boolean isOk = isDigit && isFuHao && isLetterA && isLettera;
        if (isOk)
            return 0;
        else
            return 2;
    }
}
