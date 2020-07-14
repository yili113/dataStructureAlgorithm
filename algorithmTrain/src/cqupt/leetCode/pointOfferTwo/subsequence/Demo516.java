package cqupt.leetCode.pointOfferTwo.subsequence;

/**
 * @author yiLi
 * @create 2020-07-13 12:32
 * 最大回文子序列
 */
public class Demo516 {
    // "bbbab"
    // 4
    public static int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;// 只有一个字符构成子序列时候回文最大长度就是1
        }
        // 要找到dp[0][len - 1]  表示从0下标到len-1下标构成的字符串中最大的回文子序列
        // i要是大于j  这种情况不存在 就初始化dp为0
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                dp[i][j] = 0;
            }
        }
        // 因为要找到dp[0][len-1],所以采用自底向上
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {// 这两个循环就是上三角
                if (chars[i] == chars[j])
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                else
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                // 当chars[i] != chars[j]时,就需要看i这个单独加进去与j这个位置字符单独加进去哪种情况构成的回文子序列长
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }
}
