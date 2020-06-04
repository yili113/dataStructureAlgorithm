package cqupt.leetCode.pointOffer;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-06-03 17:18
 */
public class Demo48_impor {
    public int lengthOfLongestSubstring1(String s) {
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
                map.put(chars[i], i);
                dp[i] = i - lastPos;
            }
        }
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = dp[i] > res ? dp[i] : res;
        }
        return res;
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        int temp = 0;
        for (int i = 0; i < s.length(); i++) {
            int j  = map.getOrDefault(s.charAt(i), -1);
            map.put(s.charAt(i), i);
            temp = temp < i - j ? temp + 1 : i - j;
            res = Math.max(res, temp);
        }
        return res;
    }
}
