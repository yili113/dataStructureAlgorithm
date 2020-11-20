package cqupt.writtenExamination.laoHu;

/**
 * @author yiLi
 * @create 2020-09-06 17:07
 */
public class Main2 {
    public boolean isPalindrome (String str) {
        // write code here
        String s = str.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left ++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(right))) {
                right --;
                continue;
            }
            if (s.charAt(left) != s.charAt(right))
                return false;
            left ++;
            right --;
        }
        return true;
    }
}
