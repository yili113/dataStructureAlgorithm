package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-09 18:18
 */
public class Demo65 {
    // 进位得到的数  +  不进位得到的数
    public static int add(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = a ^ b;
            b = (temp & b) << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(5, 7));
    }
}
