package cqupt.writtenExamination.huaWei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-09-06 19:01
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> stringList = new ArrayList<>();
        String edge = "";
        while (sc.hasNext()) {
            String s = sc.next();
            if (s.length() == 1) {
                edge = s;
                break;
            }else {
                stringList.add(s);
            }
        }
        String target = sc.next();
        sc.close();
        String targetFeture = getString(target, edge);
        ArrayList<String> res = new ArrayList<>();
        for(String str : stringList) {
            if (getString(str, edge).contains(targetFeture))
                res.add(str);
        }
        for(String ss : res)
            System.out.println(ss);
    }

    public static String getString(String s, String target) {
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            if ((s.charAt(i) - '0') < (target.charAt(0) - '0'))
                sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
