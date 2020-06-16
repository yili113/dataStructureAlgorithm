package cqupt.leetCode.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-06-16 11:01
 * 找到字符串中所有字母异位词
 */
public class T438 {
    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for(char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c,0) + 1);
        }
        int left = 0;
        int right = 0;
        int match = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (pMap.containsKey(c1)) {
                window.put(c1, window.getOrDefault(c1,0) + 1);
                if (window.get(c1).equals(pMap.get(c1)))
                    match ++;
            }
            right ++;
            while (match == pMap.size()) {
                // 记录结果
                if (right - left== p.length()) {// 此时right对应的就是 已匹配字符串的最右侧字符的再右边一个
                    res.add(left);
                }
                char c2 = s.charAt(left);
                if (pMap.containsKey(c2)) {
                    window.put(c2,window.get(c2) - 1);
                    if (window.get(c2) < pMap.get(c2))
                        match --;
                }
                left ++;
            }
        }
        return res;
    }
}
