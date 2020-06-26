package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-26 10:25
 */
public class Demo15 {
    public int hammingWeight1(int n) {
        String string = Integer.toBinaryString(n);
        int count = 0;
        for (char ch : string.toCharArray())
            count = ch == '1' ? count + 1 : count;
        return count;
    }
    // 逐位判断
    // >>>不带符号的右移  >>带符号的右移
    // <<<这种不存在  不可能把符号再左移了  左移只能是在低位补0
    public int hammingWeight2(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                count ++;
            n >>>= 1;
        }
        return count;
    }
}