package cqupt.leetCode.pointOffer;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-12 14:54
 * 重构乘积数组
 */
public class Demo66 {
    public static int[] constructArr(int[] a) {
        int[] an = new int[a.length];// an[i]表示a[0]*a[1]*...*a[i-1]
        int[] bn = new int[a.length];// ab[i]表示a[i+1]*...*a[a.length-1]
        int mult1 = 1;// 初始值设为1,乘积运算中都是这样赋值
        int mult2 = 1;
        for (int i = 0; i < a.length; i++) {
            an[i] = mult1;
            mult1 *= a[i];// 对i位置更新mult值
        }
        for (int j = a.length - 1; j >= 0; j--) {
            bn[j] = mult2;
            mult2 *= a[j];
        }
        System.out.println(Arrays.toString(an));
        System.out.println(Arrays.toString(bn));
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = an[i] * bn[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArr(new int[]{1,2,3,4,5})));
    }
}
