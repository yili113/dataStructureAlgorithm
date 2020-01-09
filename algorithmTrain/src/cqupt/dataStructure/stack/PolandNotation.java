package cqupt.dataStructure.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 计算后缀表达式的结果
 * @author yiLi
 * @create 2019-12-27 15:09
 */
public class PolandNotation {
    public static void main(String[] args) {
        String exp = "3 4 + 5 * 6 -";
        List<String> listString = getListString(exp);
        int result = cal(listString);
        System.out.println(result);
    }

    /**
     * @param exp
     * @return 返回由字符串组成的List
     */
    public static List<String> getListString(String exp) {
        String[] splitList = exp.split(" ");
        ArrayList<String> stringArrayList = new ArrayList<>();
        for (int i = 0; i < splitList.length; i++) {
            stringArrayList.add(splitList[i]);
        }
        return stringArrayList;
    }

    /**
     *
     * @param list 包含后缀表达式的list
     * @return
     */
    public static int cal(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String string : list){
            if (string.matches("\\d+")){// 通过正则匹配多位数
                stack.push(string);
            }else {// 遇到符号开始弹出两个数进行计算
                // 计算之后再将结果入栈
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (string.equals("+")){
                    res = num1 + num2;
                }else if (string.equals("-")){
                    res = num2 - num1;
                }else if (string.equals("*")){
                    res = num1 * num2;
                }else if (string.equals("/")){
                    res = num2 /num1;
                }else {
                    throw new RuntimeException("符号有误");
                }
                stack.push("" + res);// 数字转字符串的最简单方法  匹配的时候""就可以了  不能中间加空格
            }
        }
        return Integer.parseInt(stack.pop());
    }
    public static List<String> toInfixExpressionList(String s){
        List<String> ls = new ArrayList<>();
        int i = 0;
        String str;
        char c;
        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add(""+c);
                i ++;
            }else {
                str = "";
                while (i < s.length() && (c = s.charAt(i)) < 48 && (c = s.charAt(i)) > 57) {
                    str += c;
                    i ++;
                }
                ls.add(str);
            }
        }while (i < s.length());
        return ls;
    }
}
