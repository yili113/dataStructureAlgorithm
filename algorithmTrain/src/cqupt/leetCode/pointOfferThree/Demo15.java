package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-20 20:06
 * 二进制中1的个数
 */
public class Demo15 {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                count ++;
            n >>>= 1;
        }
        return count;
    }
}
