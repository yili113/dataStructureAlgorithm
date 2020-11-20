package cqupt.writtenExamination.keDaXunFei;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-29 19:03
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int index = 0;
        while (str.charAt(index) == '_')
            index ++;
        int last = str.length() - 1;
        while (str.charAt(last) == '_')
            last --;
        StringBuilder sb = new StringBuilder();
        for (int i = index; i <= last; i++) {
            if (str.charAt(i) == '_'  && str.charAt(i + 1) == '_') {
                continue;
            } else
                sb.append(str.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
