package cqupt.leetCode.dp;



/**
 * @author Liyi
 * @create 2020-03-01 9:20
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串
 *
 *
 * 动态规划解题。。。字符串匹配很多时候都是用动态规划来解题
 * 原则上是让两个字符串长度内容完全相等才算相等，这道题因为有了*所以长度可不等
 */
public class T10 {
    public static void main(String[] args) {
        String s = "aa";
        String p = "ab*a*c*a";
//        String s = "a";
//        String p = "aa";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }

    /**
     * 用字符串p去匹配字符串s
     * 声明:match[i][]表示s中的第i个字符 也就是s.charAt(i-1)
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;// 先判断参数形式是否正确
        // 创建的状态数组要比两个字符串长度各加1
        // match数组中的数字表示 match[1][1]一个s中的字符和一个p中的字符是否匹配
        boolean[][] match = new boolean[s.length()+1][p.length()+1];
        // 1.初始化数组
        // (1.1)0个s中的字符和0个p中的字符也是匹配的！
        match[0][0] = true;
        // (1.2)当0个s字符的时候，若p中第一个为*默认不能匹配
        // 从p的第二个字符开始若当前字符为*，则可以*的上一个字符表示0个当前字符，这时就少了p中的两个字符
        // 所以match[0][i] = match[0][i-2]
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i-1) == '*')
                match[0][i] = match[0][i-2];
        }
        // 2.match数组中间区域填写
        // 遍历开始从s的第一个字符开始到最后一个字符 p的第一个字符到最后一个字符
        for (int si = 1; si <= s.length(); si++) {
            for (int pi = 1; pi <= p.length(); pi++) {
                // (2.1) 当p中当前字符为'.'或者p中当前字符与s中当前字符相等时
                // 这时要看左上对角线的状态 因为前面要是true 这个地方也是true
                // match[si][pi] = match[si-1][pi-1];
                if (p.charAt(pi - 1) == '.' || p.charAt(pi - 1) == s.charAt(si - 1)) {
                    match[si][pi] = match[si - 1][pi - 1];
                }else if (p.charAt(pi - 1) == '*') {// (2.2) p中当前字符为 *
                    // (2.2.2) 除去*匹配0个外就是匹配前面字符的1—n个
                    // 当p的前一个字符与s的当前字符相同，p中的当前字符*才能发挥作用
                    // 例如 p=abcd*  s=abcdd可以匹配  哪怕是s=abcdddddddd也是可以匹配的
                    // 例如 p=abc.*  s=abcddddd也是可以匹配的
                    // 这样对于s而言就跟上一个情况一样
                    if (p.charAt(pi - 2) == s.charAt(si - 1) || p.charAt(pi - 2) == '.') {
                        // match[si][pi - 2]  match[si - 1][pi]有一个为true就为true
                        match[si][pi] = match[si][pi - 2] || match[si - 1][pi];// match中都是true/false是可以直接用||连接的
//                        match[si][pi] = match[si - 1][pi];// TODO 上一行注释掉的是原代码 不知道这样写的用意 s=aaa  p=ab*a*c*a时报错
                    }else {
                        // (2.2.1)*匹配前面字符的0个.跟初始化时候类似
                        // 比如说 s=abcd    p=abcde*  这种情况是可以匹配的
                        // 让p的*使e字符0个就好  这样对于p而言  就跟上两个情况一样了
                        match[si][pi] = match[si][pi - 2];
                    }
                }
            }
        }
        return match[s.length()][p.length()];
    }
}
