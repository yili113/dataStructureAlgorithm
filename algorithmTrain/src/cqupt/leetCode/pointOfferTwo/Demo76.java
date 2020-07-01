package cqupt.leetCode.pointOfferTwo;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-07-01 11:13
 * 最小覆盖子串
 */
public class Demo76 {
    // 输入: S = "ADOBECODEBANC", T = "ABC"
    // 输出: "BANC"
    public String minWindow(String s, String t) {
        if (t == null || t.length() == 0)
            return "";
        HashMap<Character, Integer> window = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        char[] chars = s.toCharArray();
        // 把t串中包含哪些元素,每个元素有多少个统计下
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0) + 1);
        }
        int match = 0;
        int left = 0;
        int right = 0;
        int start = 0;
        int min = Integer.MAX_VALUE;
        while (right < s.length()) {
            // 当match==t.length时候计算长度
            char c1 = chars[right];
            if (tMap.containsKey(c1)) {
                window.put(c1,window.getOrDefault(c1,0) + 1);
                if (window.get(c1).equals(tMap.get(c1)))
                    match ++;
            }
            right ++;
            while(match == tMap.size()) {// match是t字符串中不同元素的个数
                if ((right - left) < min) {
                    min = right - left;
                    start = left;
                }
                char c2 = chars[left];
                if (tMap.containsKey(c2)) {
                    window.put(c2, window.get(c2) - 1);
                    if (window.get(c2) < tMap.get(c2))
                        match --;
                }
                left ++;
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}
