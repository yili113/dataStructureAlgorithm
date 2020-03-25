package cqupt.leetCode.noClassified;

import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-03-25 13:09
 */
public class T344 {
    public static void reverseString1(char[] s) {
        int n = s.length;
        char temp = 0;
        for (int i = 0; i < n - 1; i++) {
            int index = 0;
            while (index < n - 1 - i) {
                temp = s[index];
                s[index] = s[index + 1];
                s[index + 1] = temp;
                index ++;
            }
        }
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    /**
     * 双指针解法
     * @param s
     */
    private static void reverseString(char[] s) {
        for (int left = 0, right = s.length - 1; left < right; left ++, right --) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
}
