package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-30 8:57
 * 斐波那契数列
 */
public class Demo10_1 {
    // 大数返回值错误
    public static int fib(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int res = 1;
        int temp = 0;
        int pre = 1;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res += pre;
            pre = temp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(fib(45));

        // 701408733
        // 433494437
        System.out.println(701408733 + 433494437);
        // 预期的 45  134903163
    }
    public static int fib1(int n) {
        if (n <= 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int a = 1;
        int b = 1;
        int sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

}
