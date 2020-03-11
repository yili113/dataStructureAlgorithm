package cqupt.leetCode;

import java.util.*;

/**
 * @author Liyi
 * @create 2020-03-03 10:02
 */
public class T17 {

    /**
     * 我的思路：遍历
     * 只考虑了数字字符长度为2的情况
     * @param digits
     * @return
     */
    public static List<String> letterCombinations1(String digits) {
        ArrayList<String> res = new ArrayList<>();
        if (digits == "" || digits == null)
            return res;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < digits.length(); i++) {
            if (digits.charAt(i) == '2') {
                list.add("abc");
            }else if (digits.charAt(i) == '3') {
                list.add("def");
            }else if (digits.charAt(i) == '4') {
                list.add("ghi");
            }else if (digits.charAt(i) == '5') {
                list.add("hkl");
            }else if (digits.charAt(i) == '6') {
                list.add("mno");
            }else if (digits.charAt(i) == '7') {
                list.add("pqrs");
            }else if (digits.charAt(i) == '8') {
                list.add("tuv");
            }else if (digits.charAt(i) == '9') {
                list.add("wxyz");
            }
        }
        char[] chars1 = list.get(0).toCharArray();
        char[] chars2 = list.get(1).toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                res.add("" + chars1[i] + chars2[j]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        List<String> strings = letterCombinations("234");
        System.out.println(strings);
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> map = new HashMap<>();
        ArrayList<String> dfsRes = new ArrayList<>();
        LinkedList<String> bfsRes = new LinkedList<>();
        if (digits == "" || digits == null)
            return bfsRes;
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'h', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});

//        dfs("", 0, digits, dfsRes, map);
        bfs("", 1, 0, digits, bfsRes , map);

        return bfsRes;
    }

    /**
     * 最终的结果都放在一个 队列中
     * @param cur 进行拼接的当前字符
     * @param curSize 当前需要从队列中poll出来元素的个数
     * @param index 遍历digits字符串的下标
     * @param digits 初始的数字字符串
     * @param queue 队列
     * @param map 数字与字符集的map
     */
    private static void bfs(String cur, int curSize, int index, String digits, LinkedList<String> queue, HashMap<Character, char[]> map) {
//        LinkedList<String> queue = new LinkedList<>();// 用链表模拟队列
        ArrayList<String> pollList = new ArrayList<>();
        queue.addLast(cur);
        while (index < digits.length()) {
            // 需要先把里面元素poll出来
            // 根据curSize大小进行poll
            for (int i = 0; i < curSize; i++) {
                pollList.add(queue.removeFirst());
            }
            for (int i = 0; i < pollList.size(); i++) {
                char[] chars = map.get(digits.charAt(index));
                for (Character c : chars) {
                    queue.addLast(pollList.get(i) + c);// 把pollList中的每个字符都拼接上新的字符
                }
            }
            pollList.clear();// 将pollList置空
            curSize *= 3;
            index ++;
        }
    }

    public static void dfs(String curString, int index, String digits, ArrayList<String> res, HashMap<Character,char[]> map) {
        // 递归出口
        if (index == digits.length())// 当遍历到最后一个字符的时候 把累加的字符串放入list
            res.add(curString);
        else {
            char c = digits.charAt(index);
            if (map.containsKey(c)) {
                for(char c1 : map.get(c)) {
//                    curString += c1;
                    // 这个是不能放在递归函数内的，因为curString可能被下一个递归给调用了 下一层变成了ad
                    // 然后递归出来之后 会接着在ad后面加e。
                    // 而作为递归参数传进去的话 参数是 curString + c1,在每层的递归的上一层的curString不会被改变
                    dfs(curString + c1, index + 1, digits, res, map);
                }
            }else {
                // map中不包含这个就什么都不做
            }
        }
    }
}
