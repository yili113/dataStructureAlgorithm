package cqupt.leetCode.pointOffer;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-06-03 17:18
 */
public class Demo48 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
//        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length];
        dp[0] = 1;
//        set.add(chars[0]);
        map.put(chars[0], 0);
        for (int i = 1; i < chars.length; i++) {
//            if (!set.contains(chars[i])) {
//                set.add(chars[i]);
//                dp[i] = dp[i - 1] + 1;
//            }else
//                dp[i] = dp[i - 1];
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], i);
                dp[i] = dp[i - 1] + 1;
            }else {
                // 这个字符之前出现过的话,往前找
                int lastPos = map.get(chars[i]);

            }
        }
        return dp[chars.length - 1];
    }
}
