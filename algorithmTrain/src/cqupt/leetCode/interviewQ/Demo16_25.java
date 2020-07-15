package cqupt.leetCode.interviewQ;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author yiLi
 * @create 2020-07-15 8:58
 */
public class Demo16_25 {
    private HashMap<Integer, Integer> map;
    private LinkedList<Integer> list;
    private int capacity;
    public Demo16_25(int capacity) {
        list = new LinkedList<>();
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            // 把最近使用的放在链表尾部
            list.remove((Integer)key);// 先把之前的key删掉
            list.addLast(key);// 再把key放在链表尾部,map中的映射不改变
            return map.get(key);
        }else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.addLast(key);
            map.put(key, value);
        }else {
            while (list.size() >= capacity) {
                Integer re = list.removeFirst();
                map.remove(re);
            }
            list.addLast(key);
            map.put(key, value);
        }
    }
}
