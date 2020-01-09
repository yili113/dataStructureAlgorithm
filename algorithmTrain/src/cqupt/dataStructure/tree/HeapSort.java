package cqupt.dataStructure.tree;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-01-07 17:05
 * 堆排序
 * 要是升序排序就做成大顶堆 不断的把堆顶的元素放在数组的最后面（把堆顶元素拿出数结构）
 */
public class HeapSort {
    public static void main(String[] args) {
        // 升序排列
        int[] arr = {4, 6, 8, 5, 9};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**]
     * 堆排序
     * @param arr
     */
    private static void heapSort(int[] arr) {
        int temp = 0;

/*        // 分部完成第一个形成大顶堆的过程
        adjustHeap(arr, 1, arr.length);
        adjustHeap(arr, 0, arr.length);
        System.out.println("第一个大顶堆的形成结果：" + Arrays.toString(arr));*/
        /**
         * 要明白一点：堆排序是有两个循环过程的，外围的是不断找出当前树结构中最大的元素，然后放在数组最后面
         * 在外围的循环中 不断改变的是length  length是需要调整的元素个数 每次形成一个大顶堆就会少一个需要
         * 调整的元素个数
         * 内围循环是 在形成某个特定的大顶堆时候 那个非叶子结点的不断改变 非叶子结点最开始是i = arr.length / 2 -1
         * 每次 i--. 因位找下一个非叶子结点的下标时候 只可能是索引减少不能增加 因为顺序存储二叉树结构就是从上往下
         * 对应的数组索引增大，找非叶子结点只能往上或者往左找，往下或者往右就是叶子了
         */
        // 1.做第一个大顶堆
        /**
         * 第一个大顶堆，需要调整的元素数量就是arr.length
         * 非叶子结点索引--
         */
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        // 2.将第一个大顶堆得到的最大元素置于末尾
        // 并且不断做大顶堆
        // 不断得到局部最大元素
        for (int i = arr.length - 1; i > 0; i--) {
            // 将最大元素置于末尾
            temp = arr[i];
            arr[i] = arr[0];// 始终是和第一个元素交换
            arr[0] = temp;
            // 做大顶堆
            // 因为实际上是从第0个结点作为非叶子结点开始遍历的
            // 在每次对大顶堆时候都以0个开始的
            // 在做大顶堆的方法中有一个向i的子结点向下遍历的循环
            // 每次做大顶堆只是将当时的那个循环中最大的元素挪动到堆顶 将当时的堆顶元素放置到末尾
            adjustHeap(arr, 0, i);// 每做一个大顶堆 length减少一个
        }
    }

    /**
     * 将当前的非叶子结点i及其子孙包含的局部树结构做成大顶堆
     * 局部！！！
     * @param arr
     * @param i 当前需要调整的非叶子结点
     * @param length 当次调整需要调整的元素个数  刚开始调整时候肯定是arr.length
     *               length是逐渐减少
     */
    private static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];// 当前的非叶子结点元素
        // 开始调整
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k ++;// 将k指向i这个非叶子结点的左右儿子结点中小的哪一个 k = i * 2 + 1是i的左儿子
            }
            if (arr[k] > temp) {// 儿子结点比i结点大了  此时就需要调整了
                arr[i] = arr[k];
                i = k;// 把i指向原本i结点的儿子结点继续比较
            }else {
                break;// 如果i结点比其两个儿子结点都大或等 就不需要调整 直接跳出for
                // 此处可以break是因为：寻找非叶子结点是从下往上，从左往右寻找的
                //如果对于当前的非叶子结点i和其子结点的位置不用换，那么就不用在查找其子节点与其孙子结点了，直接往上找
            }
        }
        // for结束之后 以i为父节点的树的最大值放在了局部的顶端
        arr[i] = temp;// 此时的temp是换下来的较小的值 并且现在i的位置是最开始i的子结点 上面用了i=k
    }
}
