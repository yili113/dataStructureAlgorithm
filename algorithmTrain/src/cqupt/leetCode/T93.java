package cqupt.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-14 11:17
 */
public class T93 {



    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<>();
        if (s == null || s.length() > 12)
            return result;
        helper(result, s, "", 0);
        return result;
    }

    /**
     *
     * @param result IP结果集
     * @param s 剩余可用的字符串
     * @param cur 当前IP中已构成的字符串
     * @param field 当前进行的部分  一共4个部分
     */
    private void helper(ArrayList<String> result, String s, String cur, int field) {
        if (field == 4 && s.length() == 0) {// field == 4 ,s.length() == 0同时满足才算有效条件
            result.add(cur.substring(1));
        }else if (field == 4 || s.length() == 0)// 无效的条件
            return;
        else {
            // 1.当前s中一个字符作为一个field
            // s.substring(1)相当于就是把第一个字符去掉 取s中后面的字符串
            helper(result, s.substring(1), cur + "." + s.substring(0, 1), field + 1);
            // 2.当前剩余s中取前两个字符作为一个field
            if (s.charAt(0) != '0' && s.length() > 1) {// s中第一个字符不为0时
                helper(result, s.substring(2), cur + "." + s.substring(0, 2), field + 1);
                // 3.当前剩余s中取三个字符作为一个field
                if (s.length() > 2 && Integer.valueOf(s.substring(0, 3)) <= 255) {
                    helper(result, s.substring(3), cur + "." + s.substring(0, 3), field +1);
                }
            }
        }
    }
}
