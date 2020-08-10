package cqupt.leetCode.pointOfferThree.netEase;

import java.util.*;

/**
 * @author yiLi
 * @create 2020-08-07 9:39
 * 小易打怪
 */
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] strs = s.trim().split(" ");
        int n = Integer.parseInt(strs[0]);
        int a = Integer.parseInt(strs[1]);
        int[] energy = new int[n];
        s = sc.nextLine();
        sc.close();
        String[] strs1 = s.trim().split(" ");
        for (int i = 0; i < n; i++) {
            energy[i] = Integer.parseInt(strs1[i]);
        }
        System.out.println(solution(n, a, energy));
    }

    public static int solution(int n, int a, int[] energy) {
        int[] dp = new int[n + 1];
        dp[0] = a;
        for (int i = 1; i <= n; i++) {
            if (dp[i - 1] >= energy[i - 1])
                dp[i] = dp[i - 1] + energy[i - 1];
            else {
                int ans = gcd(dp[i - 1], energy[i - 1]);
                dp[i] = dp[i - 1] + ans;
            }
        }
        return dp[n];
    }

    private static int gcd(int m, int n) {
        if (n == 0)
            return m;
        else
            return gcd(n, m % n);
    }
}
