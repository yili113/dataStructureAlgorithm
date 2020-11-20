package cqupt.writtenExamination.keDaXunFei;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-29 19:03
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        String next = sc.next();
        String[] strs = next.split(",");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        sc.close();
        int minIndex = 0;
        int minVal = 0;
        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            minVal = nums[minIndex];
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < minVal) {
                    minIndex = j;
                    minVal = nums[j];
                }
            }
            swap(nums, i, minIndex);
        }
        StringBuilder sb = new StringBuilder();
        for (int num : nums)
            sb.append(num).append(",");
        String string = sb.toString();
        System.out.println(string.substring(0, string.length() - 1));
    }
    public static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
