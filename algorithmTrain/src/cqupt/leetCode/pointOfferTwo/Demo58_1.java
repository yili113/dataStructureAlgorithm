package cqupt.leetCode.pointOfferTwo;

import java.util.ArrayList;

/**
 * @author yiLi
 * @create 2020-07-04 15:15
 * 翻转单词顺序
 */
public class Demo58_1 {
    public static String reverseWords(String s) {
        String str = s.trim();
        String[] strs = s.split("\\s+");
        ArrayList<String> list = new ArrayList<>();
        for (String ss : strs)
            list.add(ss);
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}
