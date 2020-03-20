package cqupt.leetCode.twoPointer;

/**
 * @author Liyi
 * @create 2020-03-20 22:24
 * 有效的回文串
 */
public class T125 {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase();
        int left = 0;
        int right = s1.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s1.charAt(left))) {// isLetterOrDigit判断是否是字母或数字
                left ++;
                continue;// left右移后重新开始while循环
            }
            if (!Character.isLetterOrDigit(s1.charAt(right))) {
                right --;
                continue;// left右移后重新开始while循环
            }
            if (s1.charAt(left) != s1.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
}
