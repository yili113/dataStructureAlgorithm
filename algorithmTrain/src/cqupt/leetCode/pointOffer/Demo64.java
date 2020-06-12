package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-12 14:31
 * 求 1+2+...+n
 */
public class Demo64 {
    public int sumNums1(int n) {
        return ((int) Math.pow(n, 2) + n) >> 1;
    }

    // 利用逻辑运算符的短路效应
    // a&&b若a为假 就不会执行b的判断
    // a||b若a为真 就不会执行b的判断
    int res = 0;

    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;// 这种递归是首先深入到n=1  虽说n=1时候这条语句为false但是后面的
        // res+=n还是会运行
        // n<=1时候只是递归截止了,不运行后面的sunNums(n-1)
        // sumNums(n - 1) > 0这个>0只是为了作为判断语句   <0也是一样
        res += n;
        return res;
    }
}