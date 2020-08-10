package cqupt.leetCode.exam;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-08 14:55
 */
public class Main1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
//        sc.close();
//        int res = 0;// 统计最后的结果
//        for (int num : nums) {
//            if (num == 3)
//                res += 1;
//            else {
//                int cur = isSushu(num);
//                res += cur;
//            }
//        }
//        System.out.println(res);
//    }
//    // 判断n可以拆成多少个素数
//    public static int isSushu(int n) {
//        if (n <= 1)
//            return 0;
//        return n / 2;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger[] nums = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextBigInteger();
        }
        sc.close();
        BigInteger res = new BigInteger("0");
        for(BigInteger num : nums) {
            if (num.equals(1))
                continue;
            BigInteger two = new BigInteger("2");
            res.add(num.divide(two));
        }
        System.out.println(res);
    }
}
