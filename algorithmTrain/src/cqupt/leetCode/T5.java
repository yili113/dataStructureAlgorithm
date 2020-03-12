package cqupt.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-12 11:00
 * 最长回文子串
 * 动态规划
 */
public class T5 {
    static List<String> list = new ArrayList<>();
    /**
     * 判断字符串是不是回文串 就要判断去掉首尾字符之后的子串是不是回文串+首尾字符是否相等
     * 到最小的子串分两种情况  1.原串是奇数长度 最小的子串只有一个字符 肯定是回文串
     * 2.原串是偶数长度 最小的子串两个字符 只要两个字符相等就是回文串
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (s == null ||len == 0)
            return s;
        boolean[][] flag = new boolean[len][len];// flag[m][n]表示下标从m到n的子串是否是回文串
        int start = 0;
        int length = 1;
        // 初始化
        for (int i = 0; i < len; i++) {
            flag[i][i] = true;// 只有一个字符的时候  都是true    此时length==1
            list.add(s.substring(i, i + 1));
        }
        // 两个字符的时候 只有两个字符相等才为true
        for (int i = 0; i < len - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                flag[i][i + 1] = true;
                start = i;
                length = 2;// 此时长度为2
                list.add(s.substring(start, start + length));
            }
        }
        // 当子串长度>2的时候     j + i - 1就是j下标开始长度为i的子串末尾字符的下标
        for (int i = 3; i <= len; i++) {// i:子串的长度   i <= len原串也算一种子串
            for (int j = 0; j + i - 1 < len; j++) {// 子串开始的位置   结束位置不能写成 j < len - i
                if (s.charAt(j) == s.charAt(j + i - 1) && flag[j + 1][j + i - 2]) {// 子串首尾字符相等并且内部小的子串是回文串
                    flag[j][j + i - 1] = true;
                    start = j;
                    length = i;// 当前子串长度为i
                    list.add(s.substring(start, start + length));
                }
            }
        }
        /**
         * 这里直接用start和length而不用判断length是否是最大的
         * 因为代码是从length为1开始逐步写的，只要有新的子串满足要求
         * length和start肯定会更新
         */
        return s.substring(start, start + length);// 左包含右不包含
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ccc"));
        System.out.println(list);
    }
}
