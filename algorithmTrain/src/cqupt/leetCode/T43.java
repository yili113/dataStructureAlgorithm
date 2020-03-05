package cqupt.leetCode;

import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-03-05 19:25
 * 字符串相乘
 */
public class T43 {



    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null)
            return "0";
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];// 预先得到乘积结果的最大长度 可能达不到这个长度
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0 ; j--) {
                int low = i + j + 1;// i,j两个下标的元素相乘时  low表示低位的下标  high表示高位的下标
                int high = i + j;
                int multiply = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 1.下面两步是改变低位
                multiply += res[low];// 最终的积的大小是两数乘出来的结果加上低位的数(此时低位的数就是上一步乘积高位上的数)
                res[low] = multiply % 10;
                // 2.下面一步是改变高位
                res[high] += multiply / 10;// 高位上的数是乘积与10的商加上原来高位的数(多位数与多位数相乘可以用上)
            }
        }
        System.out.println(Arrays.toString(res));
        // 此时结果字符串中的开头可能有0 要去掉
        StringBuilder stringBuilder = new StringBuilder();
        for(int result : res) {
            // if (result != 0 || stringBuilder != null) // 这里不能用stringBuilder是否为null  刚new出来时是""（空串）
            if (!(stringBuilder.length() == 0 && result == 0))
                stringBuilder.append(result);
        }
        if (stringBuilder.length() != 0)
            return stringBuilder.toString();
        else
            return "0";
    }

    public static void main(String[] args) {
        System.out.println(multiply("2", "3"));
    }
}
