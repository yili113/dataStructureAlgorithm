package cqupt.fromVideo;

/**
 * 二分查找法
 * 数组必须有序
 */
public class C {
    public static void main(String[] args) {
        int[] arr = {1, 4, 5, 67, 90, 122};
        int m = 0;// 开始位置
        int n = arr.length - 1;// 最终位置
        int k = 0;// 中间位置
        int num = 67;
        while (m <= n) {
            k = (m + n) / 2;
            if (num == arr[k]){
                System.out.println("找到:" + k);
                return;
            }else if (num < arr[k]) {
                n = k - 1;
            }else {
                m = k + 1;

            }
        }
        System.out.println("没有该数字");
    }

}
