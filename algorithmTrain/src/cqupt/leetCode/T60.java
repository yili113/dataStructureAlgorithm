package cqupt.leetCode;

import java.util.ArrayList;

/**
 * @author Liyi
 * @create 2020-03-08 13:16
 * 第k个排列
 */
public class T60 {
    public static void main(String[] args) {

    }

    /**
     *
     * @param n 1-n个数的由小到大的全排列
     * @param k 找第k个数   k从1开始
     * @return
     */
    // TODO
    public String getPermutation(int n, int k) {
        char[] result = new char[n];
        ArrayList<Integer> nums = new ArrayList<>();// 存放n个可用的数字
        int[] factorial = new int[n];
        factorial[0] = 1;
        // 构成阶乘的数列
        // i=2表示剩下2个数不确定的时候有factorial[2]=2种情况
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        // 将可用的数字添加到list
        for (int i = 1; i <= n ; i++) {
            nums.add(i);
        }
        // 将k转变成下标的表示形式   k原本为1的话就是第一个数  现在用来表示下标为0的数
        k --;
        // 根据k来将结果的每个数填上
        // factorial[n - 1 - i]表示还剩i个数不确定时候有多少种情况
        for (int i = 0; i < n; i++) {
            // 把数字转成字符的方法
            result[i] = Character.forDigit(nums.remove(k / factorial[n - 1 - i]), 10);
//            result[i] = Character.highSurrogate(nums.remove(k / factorial[n - 1 - i]));// 结果会乱码
            k = k % factorial[n - 1- i];
        }
        // 把字符数组转成字符串
        return new String(result);
    }
}
