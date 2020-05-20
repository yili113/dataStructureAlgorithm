package cqupt.leetCode.twoPointer;

/**
 * @author yiLi
 * @create 2020-05-19 21:37
 */
public class T680 {
    static int count = 0;
    public static boolean validPalindrome(String s) {
        if (s == null || s.length() == 0)
            return false;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                if (count == 0) {
                    count ++;// 一次没有删过字符
                    return validPalindrome(s.substring(left, right)) || validPalindrome(s.substring(left + 1, right + 1));
                }
                // 已经删除过了并且left！=right
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("deeee"));
    }
}