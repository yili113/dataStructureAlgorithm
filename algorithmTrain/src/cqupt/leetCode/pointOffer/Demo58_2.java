package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-10 15:02
 */
public class Demo58_2 {
    public String reverseLeftWords1(String s, int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(n, s.length())).append(s.substring(0, n));
        return sb.toString();
    }

    // 列表遍历拼接
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            sb.append(s.charAt(i % s.length()));// 利用取余做到循环字符串
        }
        return sb.toString();
    }

    public String reverseLeftWords2(String s, int n) {
        return s.substring(n,s.length()) + s.substring(0,n);
    }
}