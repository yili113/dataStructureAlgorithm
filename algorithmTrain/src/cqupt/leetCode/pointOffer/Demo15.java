package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-05-31 9:07
 * 二进制中1的个数
 */
public class Demo15 {
    // 垃圾方法
    public int hammingWeight(int n) {
        String string = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '1')
                count ++;
        }
        return count;
    }

    // 一个数跟1 &运算  其实就是跟 0000000...001 &运算
    // 简单来说就是判断这个数的最右位是否是1
    // 最右位是1  结果就是1
    // 时间复杂度  O(logN)  while循环
    public static int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            count ++;
            n &=(n - 1);// 这一步就是消除 n换成二进制后 右数的第一个1
            // 因为n-1肯定会把n中右数第一个1换成0  再&一下就把右数第一个1消除了
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight2(9));
    }
}
