package cqupt.leetCode.pointOffer;

import java.util.Stack;

/**
 * @author yiLi
 * @create 2020-06-10 11:16
 */
public class Demo58_1 {
    public static String reverseWords1(String s) {
        String[] str = s.trim().split("\\s+");
        Stack<String> stack = new Stack<>();
        for (String ss : str) {
            stack.push(ss);
        }
        String res = "";
        while (!stack.isEmpty()) {
            res += stack.pop();
            if (!stack.isEmpty())
                res += " ";
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("  hello world!  "));
    }

    private static String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1;// i,j指针控制一个单词的首尾
        int i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ')
                i --;
            sb.append(s.substring(i + 1, j + 1) + " ");// i对应空格位置,所以第一个字符位置i+1
            while (i >= 0 && s.charAt(i) == ' ')// 把单词间的空格跳过
                i --;
            j = i;
        }
        return sb.toString().trim();
    }
}
