package cqupt.leetCode.twoPointer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-22 20:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] ops = new int[m + 1];
        for (int i = 1; i <= m; i++) {
            ops[i] = sc.nextInt();
        }
        sc.close();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
        for (int i = 1; i < ops.length; i++) {
            if (ops[i] == 1)
                option1(nums);
            else if (ops[i] == 2)
                option2(nums);
        }
        for (int tar : nums) {
            System.out.print(tar + " ");
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }
    public static void option1(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;

    }
    public static void option2(int[] arr) {
//        int temp = 0;
//        boolean isJi = (arr.length & 1) == 1 ? true : false;
//        if (isJi) {
//            for (int i = 0; i < arr.length - 2; i+=2) {
//                temp = arr[i];
//                arr[i] = arr[i + 1];
//                arr[i + 1] = temp;
//            }
//        }else {
//            for (int i = 0; i < arr.length - 1; i+=2) {
//                temp = arr[i];
//                arr[i] = arr[i + 1];
//                arr[i + 1] = temp;
//            }
//        }
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i+=2) {
            temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }
    }
}
