package cqupt.writtenExamination.tencent;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-09-06 21:21
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        for (int i = 0; i < n; i++) {
            System.out.println(getMid(getNewArr(nums, i)));
        }
    }

    private static int[] getNewArr(int[] nums, int i) {
        int[] newArr = new int[nums.length - 1];
        int index = 0;
        for (int j = 0; j < i; j++) {
            newArr[index ++] = nums[j];
        }
        for (int j = i + 1; j < nums.length; j++) {
            newArr[index ++] = nums[j];
        }
        return newArr;
    }

    public static int getMid(int[] arr) {
        int len = arr.length;
        Arrays.sort(arr);
        return arr[arr.length / 2];
    }
}
