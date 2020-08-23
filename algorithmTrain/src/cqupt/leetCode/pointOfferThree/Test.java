package cqupt.leetCode.pointOfferThree;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author yiLi
 * @create 2020-08-17 19:10
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.reverse(list);
        char[] chars = new char[3];
        chars[0] = '1';
        chars[1] = '2';
        chars[2] = '3';
        String s = String.valueOf(chars);
        System.out.println(s);
    }
}
