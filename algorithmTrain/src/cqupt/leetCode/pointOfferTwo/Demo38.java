package cqupt.leetCode.pointOfferTwo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-28 10:20
 */
public class Demo38 {
//    输入：s = "abc"
//    输出：["abc","acb","bac","bca","cab","cba"]
    public String[] permutation(String s) {
        RES = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);// 有重复元素所以要按字典顺序排一下
        boolean[] visited = new boolean[chars.length];
        dfs(chars, 0, visited, new ArrayList<Character>());
        String[] res = new String[RES.size()];
        for (int i = 0; i < RES.size(); i++) {
            StringBuilder curSb = new StringBuilder();
            for (Character ch : RES.get(i))
                curSb.append(ch);
            res[i] = curSb.toString();
        }
        return res;
    }

    private void dfs(char[] chars, int index, boolean[] visited, ArrayList<Character> curList) {
        if (index == chars.length)
            RES.add(new ArrayList<>(curList));
        else {
            for (int i = 0; i < chars.length; i++) {
                if (!visited[i] && (i == 0 || chars[i - 1] != chars[i] || visited[i - 1])) {
                    curList.add(chars[i]);
                    visited[i] = true;
                    dfs(chars, index + 1,visited, curList);
                    curList.remove(curList.size() - 1);
                    visited[i] = false;
                }
            }
        }
    }

    ArrayList<ArrayList<Character>> RES;

}
