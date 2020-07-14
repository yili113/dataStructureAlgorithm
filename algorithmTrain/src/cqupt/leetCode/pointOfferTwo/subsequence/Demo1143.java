package cqupt.leetCode.pointOfferTwo.subsequence;

/**
 * @author yiLi
 * @create 2020-07-13 15:41
 * 最长公共子序列
 */
public class Demo1143 {
    // 输入：text1 = "ace", text2 = "abcde"
    // 输出：3
    public static int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];
        // 初始化第一行
        int index = 0;
        for (int i = 0; i < n2; i++) {
            if (text1.charAt(0) == text2.charAt(i)) {
                index = i;
                break;
            }
        }
        for (int i = index; i < n2; i++) {
            if (index == 0 && text1.charAt(0) != text2.charAt(0))
                break;
            else
                dp[0][i] = 1;
        }
        // 初始化第一列
        index = 0;
        for (int i = 0; i < n1; i++) {
            if (text2.charAt(0) == text1.charAt(i)) {
                index = i;
                break;
            }
        }
        for (int i = index; i < n1; i++) {
            if (index == 0 && text1.charAt(0) != text2.charAt(0))
                break;
            else
                dp[i][0] = 1;
        }
//        for (int[] arr : dp)
//            System.out.println(Arrays.toString(arr));
//        System.out.println();
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (text1.charAt(i) == text2.charAt(j))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
//        for (int[] arr : dp)
//            System.out.println(Arrays.toString(arr));
//        System.out.println();
        return dp[n1 - 1][n2 - 1];
    }

    public static void main(String[] args) {
        // "abcba"
        //"abcbcba"
        String text1 = "abc";
        String text2 = "def";
        System.out.println(longestCommonSubsequence(text1,text2));
    }
}
