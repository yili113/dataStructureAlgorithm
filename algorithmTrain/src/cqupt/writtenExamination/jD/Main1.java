package cqupt.writtenExamination.jD;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-27 18:59
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n];
        int num = 1;
        int index = 0;
        while (true) {
            if (index == n)
                break;
            String s = String.valueOf(num);
            char[] chars = s.toCharArray();
            boolean flag = false;
            for (int i = 0; i < chars.length; i++) {
                if(chars[i] == '2' || chars[i] == '3' || chars[i] == '5')
                    continue;
                flag = true;
            }
            if (flag) {
                num ++;
            } else {
                dp[index ++] = num;
                num ++;
            }
        }
        System.out.println(dp[n - 1]);
    }
}
