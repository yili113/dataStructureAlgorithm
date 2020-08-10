package cqupt.leetCode.pointOfferTwo.sort;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-08-10 21:59
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {542, 3, 53, 214, 14, 748};    
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr) {

        int len = arr.length;
        // 定义10个桶
        int[][] buckets = new int[10][len];
        // 统计每个桶存放元素的个数
        int[] bucketCounts = new int[10];
        int maxVal = arr[0];
        for (int num : arr)
            maxVal = Math.max(maxVal, num);
        int maxLen =( maxVal + "").length();// 最大数的位数

        for (int k = 0, n = 1; k < maxLen; k++, n *= 10) {
            // 把每个元素放进对应的桶里
            for (int i = 0; i < len; i++) {
                int index = arr[i] / n % 10;// 每一轮依次取 个位、十位、百位...
                // 第index个桶的bucketCounts[index]个元素
                // 初始时bucketCounts[index]为0
                buckets[index][bucketCounts[index]] = arr[i];
                bucketCounts[index] ++;// 每新加一个元素该桶容量要++
            }
            // 将每个桶里元素拿出来放回原数组
            int idx = 0;
            for (int i = 0; i < buckets.length; i++) {
                if (bucketCounts[i] != 0) {// 说明这个桶里面有元素
                    for (int j = 0; j < bucketCounts[i]; j++) {
                        arr[idx ++] = buckets[i][j];
                    }
                }
                bucketCounts[i] = 0;// 每次从一个桶中取完元素就要把桶置空
            }
        }


    }
}
