package cqupt.leetCode.noClassified;

import java.util.Stack;

/**
 * @author Liyi
 * @create 2020-03-03 17:09
 * 有效的括号
 */
public class T20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {// 遍历字符串中每个符号
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {// 如果是左符号就push进stack
                stack.push(s.charAt(i));
            }
            // 如果是右符号就需要比较了 与stack顶元素比较 不等则为false
            // 如果来了右符号但是stack中没有左符号那也是false
            if (s.charAt(i) == '}' || s.charAt(i) == ')' || s.charAt(i) == ']') {
                if (stack.empty())
                    return false;
                Character p = stack.pop();
                if (p == '{' && s.charAt(i) != '}')
                    return false;
                if (p == '[' && s.charAt(i) != ']')
                    return false;
                if (p == '(' && s.charAt(i) != ')')
                    return false;
            }
        }
        // 遍历完字符串之后 stack不为空就说明有多余的符号 也为false
        if (!stack.empty())
            return false;
        return true;
    }
}
