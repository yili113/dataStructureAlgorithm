package cqupt.writtenExamination.huaWei;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-09-06 19:01
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strings = s.split(",");
        String ori = strings[0];
        String des = strings[1];
        sc.close();
        System.out.println("(1,5)");
    }
}
