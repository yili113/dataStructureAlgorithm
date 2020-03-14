package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-13 8:59
 * 解码方法----动态规划
 */
public class T91 {


    public static int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int len = s.length();
        if (s.charAt(0) == '0')
            return 0;
        int[] dp = new int[len + 1];
        dp[0] = 1;// 由dp[1]和dp[2]反推出
        dp[1] = 1;// 表示s只有一个数字时不同解码个数
        for (int idx = 1; idx < len; idx++) {// 从字符串的第二位开始迭代
            if (s.charAt(idx) == '0') {// 1.如果当前数字为0 idx就不能作为一个整体 而是要和idx-1绑一起作为一个整体
                dp[idx + 1] = dp[idx - 1];// 相当于[i]=[i-2]
                if (s.charAt(idx - 1) >= '3' || s.charAt(idx - 1) <= '0')// 当前位置已经是0了，前一位置就不能大于2或者小于1
                    return 0;
            }else {// 2.当前位置不是0
                // 2.1前一位置也不是0
                if (s.charAt(idx - 1) != '0') {
                    // 2.1.1 并且当前位置绑定前一位置是有效的
                    if (Integer.valueOf(s.substring(idx - 1, idx + 1)) <= 26)
                        dp[idx + 1] = dp[idx] + dp[idx - 1];// 两种情况：1)把当前位置单独当成整体  2)把当前位置和前一位置一起当成整体
                    else // 2.1.2 当前位置绑定前一位置时无效的
                        dp[idx + 1] = dp[idx];// 此时只有一种情况 就是把当前位置单独当成整体
                }else {// 2.2前一位置是0(当前不是0)
                    dp[idx + 1] = dp[idx - 1];
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("227"));
    }
}
