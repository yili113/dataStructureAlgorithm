package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-03 9:40
 */
public class Demo44_impor {
    public static int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        // 1.确定要求的第n个数位所在的数字位数
        while(count < n) {
            n -= count;
            digit += 1;
            start *= 10;
            count = start * digit * 9;
        }
        // 2.确定数位所在的数字
        // 决定了该数位所在数字的位数之后,就能知道该位数的第一个数字是什么 3位就是 100,4位就是 1000
        // n是多出来的数位    / digit是因为该位数的数字每个数字都会占digit个数位,比如说 digit==2 也就是 10、11...
        // 每个数字占2个数位
        long num = start + (n - 1) / digit;
        // 3.确定数位在该数字中的第几位
        // %digit就能得出在该数字表示的数位中的第几位
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        System.out.println(findNthDigit(15));
    }
}
