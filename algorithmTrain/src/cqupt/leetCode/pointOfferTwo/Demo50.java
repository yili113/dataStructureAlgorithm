package cqupt.leetCode.pointOfferTwo;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-07-01 15:58
 */
public class Demo50 {
    public static char firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return ' ';
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }
//        for(Map.Entry entry : map.entrySet()) {
//            if (entry.getValue().equals(1))
//                return (char) entry.getKey();
//        }
        for (int i = 0; i < chars.length; i++) {
            if (map.get(chars[i]) == 1)
                return chars[i];
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
