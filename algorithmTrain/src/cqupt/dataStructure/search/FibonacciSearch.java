package cqupt.dataStructure.search;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-01-06 14:44
 * 斐波那契查找
 */
public class FibonacciSearch {
    static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int result = fibSearch(arr, 1234);
        System.out.println(result);
    }

    /**
     * 返回一个菲波那切数列
     * @return
     */
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        System.out.println(Arrays.toString(f));
        return f;
    }

    /**
     *
     * @param arr
     * @param key 需要查找的数
     * @return
     */
    public static int fibSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;// 表示菲波那切数列分割数值的索引
        int mid = 0;
        int[] f = fib();
        // 因为初始的k是0 要满足f[k]-1 的大小>=数组大小
        // 所以此处需要不断的k++
        while (high > f[k] - 1) {
            k++;
        }
        // 但是那个k++之后所得到的的f[k]-1的值是>=数组长度的
        // 所以需要把数组长度扩充到 f[k]值的大小
        // 不足的地方用arr[arr.length-1]填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        for (int i = high + 1; i < temp.length; i++) {// 要保证数组有序，只能补充的是最后一个元素 不能是0
            temp[i] = arr[high];
        }
        // 使用while来二分找 类似二分
        // 此时f[k]的值就是扩充之后数组的大小
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                k-=1 ;// f[k]=f[k-1]+f[k-2] 原数组长度是f[k]是可以分成两部分的 左边一部分的长度是f[k-1]
                // 右边一部分长度是f[k-2] 左边一部分的长度大于右边一部分长度
                // 假如说到了左边 那么原本的数列可以表示成 f[k-1]=f[k-2]+f[k-3]
                // mid = low + f[k - 2] - 1 此时mid值也跟着改变了
            }else if (key > temp[mid]) {
                low = mid + 1;
                k-=2;// 同上 右边一部分的长度是f[k-2]
            }else {// 找到该数值
                // 此处一定要注意：
                // 如果要查找的数是数组最右边的那个
                // 直接返回mid会超出原数组的返回 因为mid这个索引是对于temp数组来讲的而不是arr原数组
                // temp数组长度肯定会大于原数组长度
                if (mid <= high) {
                    return mid;
                }else {
                    return high;
                }
// return mid;
            }
        }
        return -1;// 未找到
    }
}
