package cqupt.leetCode.array;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-05-21 11:12
 */
public class MaxLen {
    /**
     * 在arr中找到和为k的最大子数组长度
     * @param arr
     * @param k
     * @return
     */
    public static int maxLength(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return len;
    }
    /**
     * 给定一个无序数组 arr， 其中元素可正、 可负、 可 0。求 arr 所有的子数组中
     * 正数与负数个数相等的最长子数组长度。
     */
    public int maxLen(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0)
                arr[i] = 1;
            else if (arr[i] < 0)
                arr[i] = -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(0 - sum))
                len = Math.max(i - map.get(0 - sum), len);
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return len;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3};
        System.out.println(maxLength(arr, 6));
    }
}
