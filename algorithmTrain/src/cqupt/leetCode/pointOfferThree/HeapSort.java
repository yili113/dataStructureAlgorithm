package cqupt.leetCode.pointOfferThree;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-08-03 9:00
 * 堆排序
 * O(nlogn)
 */
public class HeapSort {



    public static void main(String[] args) {
        int[] arr = {2, 10, 4, 5, 77};
//        buildHeap(arr, 5);
        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 对于i结点而言,其父结点是(i-1)/2   左子结点2*i+1  右子结点2*i+2
     * @param arr
     * @param n 要进行调整的结点个数,例如8个结点、编号是0-7
     * @param i 当前调整下的根结点
     */
    public static void heapify(int[] arr, int n, int i) {
        if (i >= n)
            return;
        int max = i;// 暂时保存父结点下标为最大值下标
        int c1 = 2 * i + 1;// 左子结点下标
        int c2 = 2 * i + 2;// 右子结点下标
        if (c1 < n && arr[c1] > arr[max])
            max = c1;
        if (c2 < n && arr[c2] > arr[max])
            max = c2;
        if (max != i) {// 只要max指向下标发生更改就交换并递归
            swap(arr, i, max);
            heapify(arr, n, max);// 递归:以新的父结点往下交换形成堆
        }
    }

    /**
     *
     * @param arr
     * @param n 当前树的结点总个数
     */
    public static void buildHeap(int[] arr, int n) {
        // 从最后一个结点的父结点开始向上进行heapify形成堆
        int lastNode = n - 1;
        int parent = (lastNode - 1) / 2;// 最后一个非叶子结点
        for (int i = parent; i >= 0; i--) {
            heapify(arr, n, i);// 不断从右到左,从下到上一直做,形成大顶堆(对每一个非叶子结点)
        }
    }

    /**
     * 堆排序
     * @param arr
     * @param n
     */
    public static void heapSort(int[] arr, int n) {
        // 1.先做成大顶堆
        buildHeap(arr, n);
        // 2.交换顶部元素与尾部元素 并不断做堆
        for (int i = n - 1; i >= 0; i--) {
            swap(arr, i, 0);// 2.1 将顶部元素与尾部元素交换,移除顶部元素
            heapify(arr, i, 0);// 2.2 接着从顶部元素作为父结点往下做heapify,并且进行操作的结点数-1
        }
        /**
         * 第一次做大顶堆时是需要对每个非叶子结点从下到上做heapify的
         * 而后面再做heapify的时候只需要做一侧即可
         * 10,3,1...2  交换头尾部元素后   2,3,1...10
         * 对2这个父结点进行heapify时候 会交换3和2 此时1对应的右子树是没动的,右子树依然满足堆结构,不需要调整
         * 交换2,3结点之后,只有原本的左子树结构变换,所以heapify中只需要递归调整一侧即可
         */
    }

    private static void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
}
