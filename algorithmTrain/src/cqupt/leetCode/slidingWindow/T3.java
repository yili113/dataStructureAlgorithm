package cqupt.leetCode.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-06-17 8:29
 */
public class T3 {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int res = Integer.MIN_VALUE;
        HashMap<Character, Integer> window = new HashMap<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            window.put(c1,window.getOrDefault(c1, 0) + 1);// 非重复子串加进到window中
            right ++;
//            if (window.get(c1) > 1) {// 如果window中出现了重复字符,就要移动left了
//                res = Math.max(res,right - left - 1);
//                // 更新left 直到window中无重复字符
//                while (window.get(c1) > 1) {
////                    window.put(c1, window.get(c1) - 1);// 此处有问题
////                    left ++;
//                    char c2 = s.charAt(left);
//                    if (c2 != c1)
//                        left ++;
//                    window.put(c1, window.get(c1) - 1);
//                }
//            }
            // 如果window中有重复字符就会一直移动left
            while (window.get(c1) > 1) {// 每次移掉的是c2字符的次数,如果c2=c1的话,就会把c1次数减掉进而出循环
                char c2 = s.charAt(left);
                window.put(c2, window.get(c2) - 1);
                left ++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return null;
        ArrayList<Integer> window = new ArrayList<>();
        int left = 0;
        int right = 0;
        int maxNum = Integer.MIN_VALUE;
        while (right < nums.length) {
            window.add(nums[right]);
            right ++;
            while (window.size() == k) {
                // 更新当前window的最大值
                res.add(getMax(window));
                window.remove(0);
                left ++;
            }
        }
        int len = res.size();
        int[] resArr = new int[len];
        for (int i = 0; i < len; i++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }

    private Integer getMax(ArrayList<Integer> window) {
        int max = Integer.MIN_VALUE;
        for (int num : window)
            max = num > max ? num : max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
