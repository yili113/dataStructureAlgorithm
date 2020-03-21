package cqupt.leetCode.twoPointer;

import java.util.HashMap;

/**
 * @author Liyi
 * @create 2020-03-21 16:55
 * 至多包含两个不同字符的最长子串
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t 。
 * 例子：eceba  ---3
 *
 * 至多两个可以按照至多k个来解
 */
public class T159_340 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int n = s.length();
        int maxLen = 0;
        int k = 2;
        HashMap<Character, Integer> map = new HashMap<>();// 用map记录每个字母出现的次数
        for (int right = 0, left = 0; right < n; right++) {
            char c = s.charAt(right);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            }else {
//                map.get(s.charAt(right)) + 1;
                map.put(c, map.get(c) + 1);
            }
            while (map.size() > k) {// 当超过2个不同字母出现时,移动左指针
                char charLeft = s.charAt(left);// 不同while中left指向的字母不一定相同
                // 此处左移的原因:因为字母超过2个后肯定要从左边开始删减,既然把left指向的字母的次数-1,就相当于少了一个left指向的字母
                // 也就是说当前left指向的字母被移除了,就用left右移表示字母从滑窗中移除
                left ++;// 让left右移
                // 把之前left指向的字母次数-1
                Integer leftValue = map.get(charLeft);
                leftValue -= 1;
                if (leftValue == 0) {// 说明之前那个left字母全部移除掉了
                    map.remove(charLeft);
                }else {
                    map.put(charLeft, leftValue);
                }
            }
            // 如果出了while循环,就说明当前最多有两个字母,计算长度
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int max = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0, left = 0; right < n; right++) {
            char charRight = s.charAt(right);
            if (map.containsKey(charRight)) {
                map.put(charRight, map.get(charRight) + 1);
            }else {
                map.put(charRight, 1);
            }
            while (map.size() > k) {
                char charLeft = s.charAt(left++);
                Integer leftValue = map.get(charLeft);
                leftValue --;
                if (leftValue == 0) {
                    map.remove(charLeft);
                }else {
                    map.put(charLeft, leftValue);
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
