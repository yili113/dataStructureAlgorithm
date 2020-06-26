package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-26 9:23
 */
public class Demo14_2 {
    public int cuttingRope(int n) {
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int a = n % 3;
        int b = n / 3;
        // 找的结论是:求次幂的结果对一个数取模,等同于中间子次幂分别对一个数取模,然后乘积
        if (a == 0)// 正好被3整除
            return (int) (getMi(3, b) % 1000000007);
        if (a == 1)// 余数为1
            return (int) (getMi(3, b - 1) % 1000000007 * 4);
        if (a == 2)// 余数为2
            return (int) (getMi(3, b) % 1000000007 * 2);
        return 0;
    }
    // 快速幂
    public static long getMi(int a, int n) {
        if (a == 1 || n == 0)
            return 1;
        if (n == 1)
            return a;
        if (n < 0)
            return 1 / (getMi(a, -(n + 1)) * a);
        long res = 1;
        while (n > 1) {
            if (n % 2 != 0) {
                res *= a;
                res %= 1000000007;
            }
            n /= 2;
            a *= a;
            a %= 1000000007;
        }
        return res * a;
    }

    public static void main(String[] args) {
        System.out.println(getMi(3, 9));
    }
}
