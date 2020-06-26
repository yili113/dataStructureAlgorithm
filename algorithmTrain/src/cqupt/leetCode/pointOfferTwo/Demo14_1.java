package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-26 9:10
 */
public class Demo14_1 {
    // 剪绳子结论：1.每段长度尽量是3    2.不能被3整除时候再另外考虑
    public int cuttingRope(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        if (n == 3)
            return 2;
        int a = n % 3;
        int b = n / 3;
        if (a == 0)// 正好被3整除
            return (int) Math.pow(3, b);
        if (a == 1)// 余数为1
            return (int) (Math.pow(3, b - 1) * 4);
        if (a == 2)// 余数为2
            return (int) (Math.pow(3, b) * 2);
        return 0;
    }
}
