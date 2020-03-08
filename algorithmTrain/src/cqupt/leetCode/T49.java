package cqupt.leetCode;

import java.util.*;

/**
 * @author Liyi
 * @create 2020-03-06 10:08
 * 字母异位词组合
 */
public class T49 {

    /**
     * 把字符串按照字典排序后的结果作为一个key
     * 这样就能找到字母相同  但是不同顺序的values
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        ArrayList<List<String>> lists = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        if (strs == null || strs.length == 0)
            return lists;
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
                map.get(s).add(str);// 如果当前这个map中没有这种key 此时不仅要new一个list，还要把当前这个str放进去，不然少一个
            }
            else
                map.get(s).add(str);
        }
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {// map中的entrySet是包含key和values的映射
//             System.out.println(str.getValue());
            ArrayList<String> list = new ArrayList<>(entry.getValue());
            lists.add(list);
        }
//        return new ArrayList<List<String>>(map.values());
        return lists;
    }


    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }
}
