package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-31 14:29
 */
public class Demo19_impor {

    public boolean isMatch(String s, String p) {
        if (s == null || p == null)
            return false;
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt( i - 1) == '*')
                dp[i][0] = dp[i - 2][0];// 对s用0个字符的那列赋值
        }
        for (int si = 1; si <= s.length(); si++) {
            for (int pi = 1; pi <= p.length(); pi++) {
                if (p.charAt(pi - 1) == s.charAt(si - 1) || p.charAt(pi - 1) == '.') {
                    dp[pi][si] = dp[pi - 1][si - 1];
                }else if (p.charAt(pi - 1) == '*') {
                    if (p.charAt(pi - 2) == s.charAt(si - 1) || p.charAt(pi - 2) == '.') {
                        dp[pi][si] = dp[pi - 2][si] || dp[pi][si - 1];
                    }else {
                        dp[pi][si] = dp[pi - 2][si];
                    }
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}
