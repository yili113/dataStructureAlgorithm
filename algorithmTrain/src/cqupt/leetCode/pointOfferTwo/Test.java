package cqupt.leetCode.pointOfferTwo;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-07-06 17:39
 */
public class Test {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        for (Integer key : map.keySet()) {
            if (key.equals(1))
                map.remove(key);
        }
    }
}
