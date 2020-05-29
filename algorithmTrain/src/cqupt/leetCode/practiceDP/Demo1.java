package cqupt.leetCode.practiceDP;

/**
 * @author yiLi
 * @create 2020-05-27 11:28
 */
public class Demo1 {

    public int f(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        return f(n - 1) + f(n - 2);
    }


    public static void main(String[] args) {
        System.out.println(2 & 1);
    }


    public int f1(int n) {
        if (n < 1)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int pre = 1;
        int res = 1;
        int temp = 0;
        for (int i = 3; i <= n ; i++) {
            temp = res;
            res = pre + res;
            pre = temp;
        }
        return res;
    }
}
