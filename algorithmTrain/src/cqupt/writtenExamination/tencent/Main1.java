package cqupt.writtenExamination.tencent;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-09-06 20:35
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] nums2 = new int[m];
        for (int i = 0; i < m; i++) {
            nums2[i] = sc.nextInt();
        }
        sc.close();
        int left = 0;
        int right = 0;
        ArrayList<Integer> res = new ArrayList<>();
        while (left < n && right < m) {
            if (nums1[left] == nums2[right]) {
                res.add(nums1[left]);
                left ++;
                right ++;
            }else if (nums1[left] < nums2[right]) {
                right ++;
            }else if (nums1[left] > nums2[right]) {
                left ++;
            }
        }
        for(int num : res) {
            System.out.print(num + " ");
        }
    }
}
