package cqupt.leetCode.twoPointer;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-08-24 20:45
 */
public class Main3 {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        int len = arr.length;
        Arrays.sort(arr);
        int max = arr[len - 1];
        int min = arr[0];
        int count = 0;
        while (true) {

        }
    }


    public static String GetMaxLength(String str) {
        char maxChar = ' ';
        int maxCount = 0;
        char tempChar = ' ';
        int tempCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == tempChar)
                tempCount++;
            else {
                if (tempCount > maxCount) {
                    maxChar = tempChar;
                    maxCount = tempCount;
                }
                tempChar = str.charAt(i);
                tempCount = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxChar);
        return sb.toString();
    }
}
