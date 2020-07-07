package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-05 9:20
 */
public class Demo58_2 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }
        sb.append(s.substring(0, n));
        return sb.toString();
    }
}
