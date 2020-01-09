package cqupt.fromVideo;

/**
 * 利用数组进行大数相乘
 */
public class A {
    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[arr.length - 1] = 2;
        arr[arr.length - 2] = 1;
        arr[arr.length - 3] = 5;
        int num = 34;
        // 1.将数组的每个元素与数相乘
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= num;
        }
        // 2.处理数组每一位元素 先进后留
        for (int i = arr.length - 1; i > 0 ; i--) {
            arr[i - 1] += arr[i] / 10;
            arr[i] %= 10;
        }
        // 3.输出
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
