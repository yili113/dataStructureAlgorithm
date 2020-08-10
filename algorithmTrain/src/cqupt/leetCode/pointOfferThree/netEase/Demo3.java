package cqupt.leetCode.pointOfferThree.netEase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author yiLi
 * @create 2020-08-07 11:22
 */
public class Demo3 {
    public static boolean isOk(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int targetValue = (arr[0] + arr[n - 1]) / 2;
        if (targetValue * 2 != (arr[0] + arr[n - 1]))// 如果首尾平均数不是整数肯定false
            return false;
        int gap = targetValue - arr[0];
        int l = 1;
        int r = n - 2;
        while (l < r) {
            if (arr[l] == targetValue && arr[r] == targetValue)
                return true;
            if ((arr[l] + gap) != targetValue || (arr[r] - gap) != targetValue)
                return false;
            l ++;
            r --;
        }
        return true;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        for (int i = 0; i < n; i++) {
//
//        }
//        String str = sc.nextLine();
//        sc.close();
//        String[] s = str.trim().split(" ");
//        int[] arr = new int[s.length];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = Integer.parseInt(s[i]);
//        }
        int[] arr = {0, 0, 50000, 100000, 50000, 0, 0, 50000, 0, 100000};
        if (isOk(arr))
            System.out.println("YES");
        else System.out.println("No");


        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);
        try {
            String s = br.readLine();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
