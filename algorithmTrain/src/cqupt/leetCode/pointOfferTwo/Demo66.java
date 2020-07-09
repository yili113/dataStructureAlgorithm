package cqupt.leetCode.pointOfferTwo;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-07-09 20:17
 */
public class Demo66 {
    // 输入: [1,2,3,4,5]
    // 输出: [120,60,40,30,24]
    // 此方法最后一个用例超时
    public static int[] constructArr1(int[] a) {
        if (a == null || a.length == 0)
            return new int[]{};
        // 定义左侧/右侧乘积数组
        int[] leftSum = new int[a.length];
        int[] rightSum = new int[a.length];
        int ln = 1;
        int rn = 1;
        int indexL = 0;
        int indexR = a.length - 1;
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            indexL = 0;
            indexR = a.length - 1;
            ln = 1;
            rn = 1;
            while (indexL < i)
                ln *= a[indexL ++];
            while (indexR > i)
                rn *= a[indexR --];
            res[i] = ln * rn;
        }
        return res;
    }
    public static int[] constructArr2(int[] a) {
        int[] leftSum = new int[a.length];
        int[] rightSum = new int[a.length];
        int ln = 1;
        int rn = 1;
        for (int i = 0; i < a.length; i++) {
            leftSum[i] = ln;
            ln *= a[i];
        }
        for (int i = a.length - 1; i >= 0; i--) {
            rightSum[i] = rn;
            rn *= a[i];
        }
        int[] res = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            res[i] = leftSum[i] * rightSum[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(Arrays.toString(constructArr2(nums)));
    }
}
