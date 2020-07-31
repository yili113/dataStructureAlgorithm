package cqupt.leetCode.pointOfferThree;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-07-30 11:03
 * 最长不含重复字符的子串长度
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class Demo48 {
    // 滑动窗口
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        // 存放窗口中每个字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = Integer.MIN_VALUE;
        while (right < chars.length) {
            char c1 = chars[right];
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            right ++;

            while (map.get(c1) >= 2) {// 此时就需要移动left指针
                // 在这里计算长度
                char c2 = chars[left];
                map.put(c2, map.get(c2) - 1);
                left ++;
            }
            maxLen = Math.max(maxLen, right - left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        HashMap<Character, Integer> map = new HashMap<>();
        char c1 = 'c';
//        map.put(c1, map.getOrDefault(c1, 1));// 这种方式在c1原本不存在时候是没有区别的 但是原本c1有值,这样写就不会+1了
        map.put(c1, map.getOrDefault(c1, 0) + 1);
        System.out.println(map.get(c1));
    }
}
