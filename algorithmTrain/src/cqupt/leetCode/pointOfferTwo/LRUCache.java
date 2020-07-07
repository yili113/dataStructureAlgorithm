package cqupt.leetCode.pointOfferTwo;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author yiLi
 * @create 2020-07-06 19:50
 */
public class LRUCache extends LinkedHashMap {
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_SIZE;
    }

    private static final int MAX_SIZE = 3;

    public LRUCache() {
        super(MAX_SIZE, 0.75f, true);// 这个true表示维护LRU顺序
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        lruCache.put(1,"a");
        lruCache.put(2,"b");
        lruCache.put(3,"c");
        lruCache.get(1);
        lruCache.put(4,"d");
        System.out.println(lruCache.keySet());
    }
}

