package cqupt.leetCode.pointOfferTwo;

import java.util.*;

/**
 * @author yiLi
 * @create 2020-08-14 9:12
 */
public class HashMapSort {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("aa", 8);
        map.put("bb", 2);
        map.put("cc", 3);
        map.put("dd", 1);

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry s : list) {
            System.out.println(s.getKey() + " :" + s.getValue());
        }
    }
}
