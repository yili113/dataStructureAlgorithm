package cqupt.leetCode.pointOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-06-02 9:47
 */
public class Demo38 {
    private ArrayList<List<Character>> res;
    public String[] permutation(String s) {
        if (s == null || s.length() == 0)
            return new String[]{};
        res = new ArrayList<>();
        char[] chars = s.toCharArray();
        boolean[] visited = new boolean[chars.length];
//        helper1(chars, new ArrayList<Character>(), new HashSet<Character>());

        Arrays.sort(chars);
        helper(chars, new ArrayList<Character>(), 0, visited);
        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
//            result[i] = res.get(i).toString();
            String str = "";
            for (char ch : res.get(i)) {
                str += ch;
            }
            result[i] = str;
        }
        return result;
    }

    private void helper(char[] chars, ArrayList<Character> curList, int index, boolean[] visited) {
        if (index == chars.length) {
            res.add(new ArrayList<>(curList));
        }else {
            for (int i = 0; i < chars.length; i++) {
                if (!visited[i] && (index == 0 || visited[index] != visited[index - 1] || visited[i - 1])) {
                    curList.add(chars[i]);
                    visited[i] = true;
                    helper(chars, curList, index + 1, visited);
                    curList.remove(curList.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    // 没有重复元素的情况
    private void helper1(char[] chars, ArrayList<Character> curList, HashSet<Character> set) {
        if (curList.size() == chars.length) {
            res.add(new ArrayList<>(curList));
        }else {
            for (int i = 0; i < chars.length; i++) {
                if (!set.contains(chars[i])) {
                    set.add(chars[i]);
                    curList.add(chars[i]);
                    helper1(chars, curList, set);
                    curList.remove(curList.size() - 1);
                    set.remove(chars[i]);
                }
            }
        }
    }

    public static void main(String[] args) {
        Demo38 demo38 = new Demo38();
        System.out.println(Arrays.toString(demo38.permutation("acb")));
    }
}
