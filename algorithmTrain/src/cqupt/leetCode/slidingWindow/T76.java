package cqupt.leetCode.slidingWindow;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-06-16 10:05
 * 最小覆盖子串
 */
public class T76 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0)
            return "";
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        // 将needs map初始化 按照t字符串中字符出现的次数
        for(char ch : t.toCharArray()) {
            needs.put(ch, needs.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int match = 0;// window与needs的匹配字符数
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (needs.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if(window.get(c).equals(needs.get(c)))
                    match ++;
            }
            right ++;
            while (match == needs.size()) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                // left指针右移,直到不满足window条件
                char c2 = s.charAt(left);
                if (needs.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < needs.get(c2))
                        match --;
                }
                left ++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen - 1);
    }
}
