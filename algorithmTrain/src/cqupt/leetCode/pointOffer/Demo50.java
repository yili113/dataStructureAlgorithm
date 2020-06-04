package cqupt.leetCode.pointOffer;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-06-04 16:49
 */
public class Demo50 {
    public char firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            }else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return s.charAt(i);
        }
        return ' ';
    }
}
