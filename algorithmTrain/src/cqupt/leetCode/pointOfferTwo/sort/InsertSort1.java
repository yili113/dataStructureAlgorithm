package cqupt.leetCode.pointOfferTwo.sort;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-08-12 20:40
 */
public class InsertSort1 {
    public static void main(String[] args) {
        int[] arr = {542, 3, 53, 214, 14, 22};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertSort(int[] arr) {
        int n = arr.length;
        // 第一轮
//        int insertIndex = 0;
//        int insertVal = arr[1];// 表示要进行插入操作的元素
//        while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
//            arr[insertIndex + 1] = arr[insertIndex];
//            insertIndex --;
//        }
//        arr[insertIndex + 1] = insertVal;

        // 共需要将n-1个元素插进去 n-1轮
        int insertIndex = 0;// 表示要进行插入操作元素的前一个位置
        int insertVal = 0;
        for (int i = 1; i < n; i++) {
            insertIndex = i - 1;
            insertVal = arr[i];
            while (insertIndex >= 0 && arr[insertIndex] > insertVal) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }
//            arr[insertIndex + 1] = insertVal;
            // 优化就是判断这个insetIndex是否发生改变
            // 没改变就说明要插入的数的前面数都比其大
            if (insertIndex == (i - 1))
                continue;
            arr[insertIndex + 1] = insertVal;
        }
    }
}
