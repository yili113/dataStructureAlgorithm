package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-30 8:35
 */
public class Demo44 {
    public int findNthDigit(int n) {
        // 1.找到n是属于几位数构成的数位中的
        int digit = 1;
        long start = 1;// 在大数运算中定义成int会出错
        long count = 9;// 初始化先减由一位数构成的数位
        while (n > count) {
            n -= count;
            start *= 10;
            digit += 1;
            count = 9 * digit * start;
        }
        // 2.找到digit位数中的具体哪一个数
        long num = start + (n - 1) / digit;// 这个位数中每个数都占了digit个数位
        // 3.找到在num这个数中具体是哪一个数位
        // 此时剩下的数位个数n肯定是小于digit的
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }
}
