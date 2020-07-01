package cqupt.leetCode.pointOfferTwo;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-07-01 9:05
 */
public class Demo48 {
    // 动态规划
    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0)
            return 0;
        char[] chars = s.toCharArray();
        int len = chars.length;
//        int[] dp = new int[len];
//        dp[0] = 1;
//        for (int i = 1; i < len; i++) {
//            int j = i - 1;
//            while (j >= 0 && chars[j] != chars[i])
//                j --;
//            // while出来之后chars[j]=chars[i]
//            dp[i] = i - j;
//        }
        // 以上和以下这两个方式不能解决 i前面有相同的但是与i不同的情况
//        HashMap<Character, Integer> map = new HashMap<>();// value存放当前字符上一次出现的索引
//        dp[0] = 1;
//        map.put(chars[0], 0);
//        for (int i = 1; i < len; i++) {
//            if (!map.containsKey(chars[i])) {
//                dp[i] = dp[i - 1] + 1;
//                map.put(chars[i], i);
//            }else {
//                Integer lastIndex = map.get(chars[i]);
//                map.put(chars[i], i);
//                dp[i] = i - lastIndex;
//            }
//        }
        int[] dp = new int[len];
        HashMap<Character, Integer> map = new HashMap<>();
        int temp = 0;
        int max = 0;
        for (int i = 0; i < len; i++) {
            Integer lastIndex = map.getOrDefault(chars[i], -1);// 表示chars[i]上一次出现的位置
            // 如果是第一次出现,上一次出现的位置就是-1
            map.put(chars[i], i);
            if (temp < (i - lastIndex)) {// 只有当dp[i-1]的长度不包含chars[i]上一次的位置就行
                temp += 1;
            }
            else {// 如果包含了还是采用temp+=1的话就会出现重复的chars[i]元素
                temp = i - lastIndex;
            }
            max = Math.max(max,temp);
        }
        return max;
    }

    // 滑动窗口
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();// value代表该字符出现的次数
        while(right < s.length()) {
            char c1 = s.charAt(right);
            map.put(c1,map.getOrDefault(c1,0) + 1);
            right ++;
            while (map.get(c1) > 1) {
                // 开始从滑动窗口中移除元素
                char c2 = s.charAt(left);
                map.put(c2, map.get(c2) - 1);// 一直移除c2 当c2==c1时候 再移除就是c1的个数<=1了  就又能加元素了
                left ++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }


        public static void main(String[] args) {
        String str = "abba";
        System.out.println(lengthOfLongestSubstring1(str));
    }
}
