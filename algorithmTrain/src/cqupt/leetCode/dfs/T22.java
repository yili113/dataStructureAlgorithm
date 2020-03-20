package cqupt.leetCode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-03 22:08
    括号的生成
 */
public class T22 {
    public static void main(String[] args) {
        T22 t22 = new T22();
        List<String> list = t22.generateParenthesis(5);
        System.out.println(list);
    }
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
//        helper("", list, n, 0, 0);
        dfs("", list, n, n);
        return list;
    }

    /**
     *
     * @param cur
     * @param result
     * @param left 剩余的左括号个数
     * @param right 剩余的右括号个数
     */
    private void dfs(String cur, ArrayList<String> result, int left, int right) {
        if (left == 0 && right ==0) {
            result.add(cur);
        }else {
            // 左括号的条件---只要左括号还有剩余就能加
            if (left > 0) {
                dfs(cur + "(", result, left - 1, right);
            }
            // 加右括号条件---已有的左括号大于右括号个数
            else if (left < right) {
                dfs(cur + ")", result, left, right - 1);
            }
        }
    }

    /**
     *
     * @param curString 存放满足要求得字符串  n对括号满足要求的一种
     * @param list 存放所有满足要求的字符串
     * @param n n对括号
     * @param left 已有左括号的个数
     * @param right 已有右括号的个数
     */
    private void helper(String curString, ArrayList<String> list, int n, int left, int right) {
        // 递归出口
        if (right == n) {
            list.add(curString);
            return;
        }
        // 放入左括号的条件 当左括号数小于n时候就能放
        if (left < n) {
            helper(curString + "(", list, n, left + 1, right);
        }
        // 放入右括号的条件 当已有右括号小于左括号时候才能放
        if (right < left) {
            helper(curString + ")", list, n, left, right + 1);
        }
    }
}
