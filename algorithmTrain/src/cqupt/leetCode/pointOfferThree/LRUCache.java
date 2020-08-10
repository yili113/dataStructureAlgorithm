package cqupt.leetCode.pointOfferThree;

import java.util.HashMap;
import java.util.LinkedList;
/**
 * @author yiLi
 * @create 2020-08-06 21:15
 * 利用链表和map实现LRU
 * list根据操作先后顺序进行存放元素
 * 存放的是map中的key
 */
public class LRUCache {
    private LinkedList<Integer> list;
    private HashMap<Integer, Integer> map;
    private int capacity;


    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.list = new LinkedList<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            list.addLast(key);
            return map.get(key);
        }else
            return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            list.remove((Integer) key);
            map.put(key, value);
            list.addLast(key);
        }else {
            if (list.size() >= capacity) {
                Integer reKey = list.pollFirst();
                map.remove(reKey);
            }
            list.addLast(key);
            map.put(key, value);
        }
    }
}
