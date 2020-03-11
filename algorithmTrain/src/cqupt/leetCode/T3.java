package cqupt.leetCode;

import java.util.HashMap;

/**
 * @author Liyi
 * @create 2020-02-25 15:42
 * T3 无重复字符的最长子串
 */
public class T3 {


    /**
     * 此方法不行
     "abcabcbb"这种例子可以
     "dvdf"这种例子 遇到第二个d时  应该回溯 回溯到上个d的后面一个开始
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            count ++;
            if (!map.keySet().contains(chars[i])) {
                map.put(chars[i], count);
            }else {
                count = 1;
            }
        }
        int maxCount = 0;
        for(Character c : map.keySet()) {
            if (map.get(c) > maxCount)
                maxCount = map.get(c);
        }
        return maxCount;
    }

    /**
     * 正确解法
     * 解决有无重复元素的题  利用boolean数组
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() < 1) {
            return 0;
        }
        int left = 0, right = 0;
        boolean[] visited = new boolean[128];
        int max = 0;
        while (right < s.length()) {// right没到结尾就一直执行
            if (visited[s.charAt(right)] == false) {
                visited[s.charAt(right)] = true;
                right++;// 不断移动right指针
            }else {
                // 当right指向访问过的字符时候 要计算一下长度 存起来 方便与后续的比较
                max = Math.max(max, right - left);
                while (left < right && s.charAt(left) != s.charAt(right)) {
                    visited[s.charAt(left)] = false;// 回溯 ！  因为left指针位置变了 之前访问过的可以重新访问了
                    left++;// 不断移动left指针 直到遇到与right一样的字符
                }
                // 如果没有这两个指针++ 则会陷入死循环：dvdfe-->第一个d一直是true,没有改成false,而right一直指向第二个d
                // left一直指向第一个d 会一直死在else中
                // 也就是没有一条语句改变left和right的指向 原地卡死
                left++;
                right++;
            }
        }
        return Math.max(max, right - left);// 因为right指向的是正在访问的 就是right-left
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("tmmzuxt"));
    }
}
