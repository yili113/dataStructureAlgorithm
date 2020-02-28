package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-02-28 13:01
 * 正数反转
 */
public class T7 {

    public static void main(String[] args) {
        int reverse = reverse(1534236469);
        System.out.println(reverse);
    }

    /**
     *  假设1234
     *  第一轮 newRev = rev * 10 + x % 10 = 4
     *  第二轮 4*10+123%10 = 43
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int rev = 0;// 记录最终反转的结果
        while (x != 0) {
            // x % 10 会得到数的最后一位
            int newRev = rev * 10 + x % 10;// 临时存储反转后的数
            if ((newRev - x % 10) / 10 != rev)// 判断是否溢出
                return 0;
            rev = newRev;
            x = x / 10;// x表示的数会一位一位的减少，抹除最后一位
        }
        return rev;
    }
}
