package cqupt.leetCode.pointOfferThree.netEase;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-08 12:05
 * 字母卡片
 */
public class Demo5 {
    public static void main(String[] args) {
        int res = 0;
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        String str = sc.next();
        sc.close();
        char[] chars = str.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> (y - x));
        for(Character key : map.keySet())
            pq.add(map.get(key));
        while (n > 0 && !pq.isEmpty()) {
            Integer cur = pq.poll();
            if (n >= cur) {
                res += cur * cur;
                n -= cur;
            }else {
                res += n * n;
                n = 0;
            }
        }
        System.out.println(res);
    }
}
