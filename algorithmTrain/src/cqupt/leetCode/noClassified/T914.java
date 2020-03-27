package cqupt.leetCode.noClassified;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Liyi
 * @create 2020-03-27 11:14
 * 卡牌分组
 */
public class T914 {

    public static boolean hasGroupsSizeX(int[] deck) {
        if (deck == null || deck.length == 0)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++) {
            if (!map.containsKey(deck[i])) {
                map.put(deck[i], 1);
            }else {
                map.put(deck[i], map.get(deck[i]) + 1);
            }
        }
        int X = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            X = gcd(X, entry.getValue());
            if (X < 2)
                return false;
        }
        return X >= 2;
    }

    public static void main(String[] args) {
        int[] deck = {1, 1, 1, 2, 2, 2, 2, 2, 2};
        System.out.println(hasGroupsSizeX(deck));
    }

    /**
     * 求最大公约数---辗转相除
     * @param a
     * @param b
     * @return
     */
    private static int gcd (int a, int b) {
        return b == 0 ? a : gcd(b, a % b);// 如果余数不为0,进行(除数,余数)继续运算;如果余数为0就返回当前这个除数
    }
}
