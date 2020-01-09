package cqupt.fromVideo;

/**
 * 插入排序
 */
public class B {
    public static void main(String[] args) {
        int[] arr = {5, 3, 6, 1, 9, 10};
        // 第一个for 从第一个位置开始
        for (int i = 1; i < arr.length; i++) {
            // 第二个for 从0到i-1
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {// 此时需要把arr[i]插前面去
                    int temp = arr[i];
                    // 第三个for 把j位置往后的元素整体向后移 腾位置
                    for (int k = i - 1; k >= j ; k--) {
                        arr[k + 1] = arr[k];
                    }
                    arr[j] = temp;// 放到合适的位置
                    break;// 退出j循环
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
