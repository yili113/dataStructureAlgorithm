package cqupt.writtenExamination.xieCheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-09-08 19:39
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.split(" ");
        RES = new ArrayList<>();
        int maxLen = Integer.MIN_VALUE;
        for(String ss : strs)
            maxLen = Math.max(ss.length(), maxLen);
        boolean[][] visited = new boolean[strs.length][maxLen];
        helper(strs, 0, 0, new ArrayList<Character>(), visited);
        System.out.println(RES.size());
        for(ArrayList<Character> list : RES) {
            System.out.println(list);
        }
    }

    // index表示外层的下标,idx表示内层的下标
    private static void helper(String[] strs, int index, int idx, ArrayList<Character> curList, boolean[][] visited) {
        if (index == strs.length) {
            RES.add(new ArrayList<>(curList));
        }else if (idx == strs[index].length()){// 表示内层的字符串到达末端
            helper(strs, index + 1, 0, curList, visited);
        }else {// 内层没走完
            if (!visited[index][idx]) {
                curList.add(strs[index].charAt(idx));
                visited[index][idx] = true;
                helper(strs, index, idx + 1, curList, visited);
                curList.remove(curList.size() - 1);
                visited[index][idx] = false;
            }
        }
    }

    public static List<ArrayList<Character>> RES;
}
