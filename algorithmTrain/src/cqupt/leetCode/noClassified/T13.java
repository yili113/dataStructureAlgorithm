package cqupt.leetCode.noClassified;

import java.util.HashMap;

/**
 * @author Liyi
 * @create 2020-03-01 14:48
  罗马数字转整数
 我的思路：就是把字符对应的数组相加
 */
public class T13 {
    public static void main(String[] args) {
        String s = "III";
        int res = romanToInt(s);
        System.out.println(res);

    }

    private static int romanToInt(String s) {
        int res = 0;
        if (s.indexOf("IV") != -1 )
            res -= 2;
        if (s.indexOf("IX") != -1)
            res -= 2;
        if (s.indexOf("XL") != -1 )
            res -= 20;
        if (s.indexOf("XC") != -1)
            res -= 20;
        if (s.indexOf("CD") != -1)
            res -= 200;
        if (s.indexOf("CM") != -1)
            res -= 200;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I')
                res += 1;
            if (s.charAt(i) == 'V')
                res += 5;
            if (s.charAt(i) == 'X')
                res += 10;
            if (s.charAt(i) == 'L')
                res += 50;
            if (s.charAt(i) == 'C')
                res += 100;
            if (s.charAt(i) == 'D')
                res += 500;
            if (s.charAt(i) == 'M')
                res += 1000;
        }
        return res;
    }

    public static int romanToInt1(String s) {

/*        字符          数值
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。

        */
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] chars = s.toCharArray();
        int index = 0;
        int res = 0;// 存放结果的数
        while (index < chars.length - 1) {
            if (chars[index] == 'I') {
                if (chars[index + 1] == 'V') {
                    res = res + 4;
                    index += 2;
                }else if (chars[index + 1] == 'X') {
                    res = res + 9;
                    index += 2;
                }else {
                    res = res + 1;// 剩下的只是 1的情况
                    index += 1;
                }
            }else if (chars[index] == 'X') {
                if (chars[index + 1] == 'L') {
                    res = res + 40;
                    index += 2;
                }else if (chars[index + 1] == 'C') {
                    res = res + 90;
                    index += 2;
                }else {
                    res += 10;
                    index += 1;
                }
            }else if (chars[index] == 'C'){
                if (chars[index + 1] == 'D') {
                    res = res + 400;
                    index += 2;
                }else if (chars[index + 1] == 'M') {
                    res = res + 900;
                    index += 2;
                }else {
                    res += 100;
                    index += 1;
                }
            }else {
                if (chars[index] == 'V') {
                    res = res + 5;
                    index ++;
                }else if (chars[index] == 'L') {
                    res = res + 50;
                    index ++;
                }else if (chars[index] == 'D') {
                    res = res + 500;
                    index ++;
                }else if (chars[index] == 'M') {
                    res = res + 1000;
                    index ++;
                }
            }
        }
        if(chars[chars.length - 2] != 'I' && chars[chars.length - 2] != 'X' && chars[chars.length - 2] != 'C') {
            for(Character c : map.keySet()) {
                if (c == chars[chars.length - 1])
                    res = res + map.get(c);
            }
        }
        return res;
    }
}
