package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-15 8:32
 */
public class Demo67 {
    // todo
    public static int strToInt1(String str) {
        if (str == null || str.length() == 0)
            return 0;
        boolean isNeg = false;
        // 找边界
        int l = 0;
        int r = 0;
        while (!(Character.isDigit(str.charAt(l)) || str.charAt(l) == '-'))
            l ++;
        System.out.println(l);
        int index = 0;
        if (str.charAt(l) == '-') {
            isNeg = true;
        }
        if (isNeg) {
            index = l + 1;
        }
        else index = l;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            index ++;
        }
        r = index;
        System.out.println(r);
        return Integer.parseInt(str.substring(l, r));
    }
    public static void main(String[] args) {
        System.out.println(strToInt("4193 with words"));
//        System.out.println(Integer.MAX_VALUE + " " + Integer.MIN_VALUE);// 2147483647   -2147483648
    }

    public static int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        if (chars.length <= 0)
            return 0;
        boolean isNeg = false;
        if (chars[0] == '-')
            isNeg = true;
        int wall = Integer.MAX_VALUE / 10;
        int i = 0; // 正数时候i=0
        if (isNeg) i = 1;// 负数时候 i=1
        if (chars[0] == '+') i = 1;
        int res = 0;
        for (int j = i; j < chars.length; j++) {
            if (chars[j] > '9' || chars[j] < '0')
                break;
            if (res > wall || res == wall && chars[j] > '7')// 假设现在res是214748364 再加上的数大于7 就越界了
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            res = res * 10 + chars[j] - '0';
        }
        return isNeg ? -1 * (int)res : (int)res;
    }
}
