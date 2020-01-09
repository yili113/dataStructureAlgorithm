package cqupt.dataStructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author yiLi
 * @create 2019-12-29 19:29
 */
public class Sort {
    public static void main(String[] args) {
/*        int[] arr1 = {3, 9, -1, 10, -2};
        int[] arr = {-9, 78, 0, 23, -567, 70};
        System.out.println("原始数组是："+Arrays.toString(arr));*/
//        int[] arr = {-9, 78, 0, 23, -567, 70};
        int[] arr = {53, 3, 542, 748, 14, 214};
        int[] bigArr = new int[8];
        for (int i = 0; i < bigArr.length; i++) {
            bigArr[i] = (int) (Math.random() * 80000000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr1 = simpleDateFormat.format(date1);
        System.out.printf("开始排序前的时间是%s", dateStr1);
//        bubbleSort(bigArr);
//        shellSortShift(bigArr);
//        quickSort(arr, 0, bigArr.length);
        Date date2 = new Date();
        String dateStr2 = simpleDateFormat.format(date2);
        System.out.println();
        System.out.printf("结束排序的时间是%s", dateStr2);
        System.out.println();
//        selectSort(arr);
//        insertSort(arr);
//        shellSortSwop(arr);
//        shellSortShift(arr);
//        quickSort(arr, 0, arr.length - 1);
        int[] temp = new int[arr.length];
//        mergeSort(arr,0, arr.length - 1, temp);
        radix(bigArr);
        System.out.println("最终的排序结果"+Arrays.toString(bigArr));
    }

    /**
     * 桶排序
     * 用空间换时间的算法
     * @param arr
     */
    private static void radix(int[] arr) {
        // 二维数组的长度只能取arr.length
        int[][] bucket = new int[10][arr.length];// 10个桶 每个桶存放数据
        int[] bucketEleCounts = new int[10];// 记录每个桶中元素个数
        // bucketEleCounts[1] = 2 表示第2个桶中有2个元素

        // 经过几轮跟数组元素最大元素位数有关
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max)
                max = arr[i];
        }
        // 计算max的位数 拼接成字符串然后求字符串的长度!!!!
        int len = (max+"").length();
        for (int k = 0, n = 1; k < len; k++, n *= 10) {// 循环几轮 个位-->十位-->百位...
            for (int i = 0; i < arr.length; i++) {
                int digit = arr[i] / n % 10;// 取每个数的个位  123的十位求法：123/10=12 12%10=2  为2
                // 放入到相对应的桶中
                bucket[digit][bucketEleCounts[digit]] = arr[i];// bucketEleCounts[digit]初始为0
                bucketEleCounts[digit] ++;
            }
            // 经过上述for,数字已经放入到第一轮个位桶中了
            int index = 0;
            // 遍历每个桶，将桶中数据放入原数组中
            for (int i = 0; i < bucket.length; i++) {
                // 如果桶中有数据 再放
                if (bucketEleCounts[i] != 0) {
                    for (int j = 0; j < bucketEleCounts[i]; j++) {// 遍历第i个桶中的bucketEleCounts[i]个元素
                        // 取出元素放到原数组中
                        arr[index] = bucket[i][j];
                        index ++;
                    }
                }
                // 每轮处理后 需要将桶置空
                bucketEleCounts[i] = 0;
            }
        }
 /*       // 第一轮 取个位进行排序
        for (int i = 0; i < arr.length; i++) {
            int digit = arr[i] % 10;// 取每个数的个位
            // 放入到相对应的桶中
            bucket[digit][bucketEleCounts[digit]] = arr[i];// bucketEleCounts[digit]初始为0
            bucketEleCounts[digit] ++;
        }
        // 经过上述for,数字已经放入到第一轮个位桶中了
        int index = 0;
        // 遍历每个桶，将桶中数据放入原数组中
        for (int i = 0; i < bucket.length; i++) {
            // 如果桶中有数据 再放
            if (bucketEleCounts[i] != 0) {
                for (int j = 0; j < bucketEleCounts[i]; j++) {// 遍历第i个桶中的bucketEleCounts[i]个元素
                    // 取出元素放到原数组中
                    arr[index] = bucket[i][j];
                    index ++;
                }
            }
            // 每轮处理后 需要将桶置空
            bucketEleCounts[i] = 0;
        }*/


    }

    /**
     * 归并排序
     * @param left
     * @param right
     * @param temp
     */
    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left+right)/2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);
            merge(arr, left, mid, right, temp);
        }
    }
    /**
     * 合并
     * 合并的次数是数组长度-1次
     * 在合并的时候两侧的数组已经是有序的了
     * 第一步：将两侧的按照大小先填入到temp中
     * 第二步：将其中一侧没填完的继续按照顺序填到temp中
     * 第三步：将合并之后的拷贝到原数组中arr，每次合并都会拷贝，只有最后一次合并才是全部拷贝
     * @param arr
     * @param left 左边部分的初始索引
     * @param mid 中间位置
     * @param right 右边界
     * @param temp
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // 执行此方法的时候 左右两侧的数组都是有序的 只需要进行单一的合并操作即可
        int i = left;// 左边部分的初始索引
        int j = mid + 1;// 右边部分的初始索引
        int t = 0;// temp数组的索引
        // 第一步：将两侧的按照大小先填入到temp中
        while (i <= mid && j <= right) {// 两侧的均没合并完
            // 比较索引i和j的值
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                t += 1;
                i += 1;
            }else {
                temp[t] = arr[j];
                t += 1;
                j += 1;
            }
        }
        // 第二步：将其中一侧没填完的继续按照顺序填到temp中
        while (i <= mid) {
            temp[t] = arr[i];
            t += 1;
            i += 1;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t += 1;
            j += 1;
        }
        // 第三步：将合并之后的拷贝到原数组中arr，每次合并都会拷贝，只有最后一次合并才是全部拷贝
        t = 0;
        int tempLeft = left;// 每层的这个left都是不同的
            System.out.println("left是："+left+" ----"+"right是："+right);
            while (tempLeft <= right) {
                arr[tempLeft] = temp[t];
                t += 1;
                tempLeft += 1;
        }
    }
    /**
     * 快速排序
     * @param arr
     * @param left
     * @param right
     */
    private static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int pivot = arr[(l + r) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < pivot) {
                l += 1;
            }
            while (arr[r] > pivot) {
                r -= 1;
            }
            if (l >= r) // 如果满足这个条件说明 pivot左边全是比其小的 右边全是比其大的
            {
                break;
            }
            // 交换  交换和出口条件先后顺序无所谓
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            // 下面的if表明 l的索引的位置已经是pivot了 此时r肯定是l+1的位置 所以让r-1 促使l==r 满足循环跳出的条件
            if (arr[l] == pivot)
                r -= 1;
            if (arr[r] == pivot)
                l += 1;
        }
        // 出了上面的循环后 l==r 或者 l > r
        // 下面操作防止栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }
        // 出来之后向左递归的时候 右边界就是 r   因为上述循环之后出来时候可能是 r < l
        // r可能到了l的左边
        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }

    }


    /**
     * 使用插入法的希尔排序
     * 这种插入是对每组进行分别插入
     * 直接插入是对原始数组中每个乱序元素都进行插入
     * 插入的关键是：要保证待插入元素的前一个位置大于等于0才行  要不人这个元素没法插了
     * 希尔里面就是 j-gap >= 0   直接插入就是 j-1>=0
     * @param arr
     */
    private static void shellSortShift(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;// 待插入的索引
                int temp = arr[j];// 待插入的元素
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                // 退出了while表示找到了temp的插入位置
                arr[j] = temp;
            }
        }
    }

    /**
     * 希尔排序
     * 不断缩短步长 直到步长<=0 结束
     * 每组只是两个元素 一直使用数组长度/2
     * 每组元素使用交换法
     * @param arr
     */
    private static void shellSortSwop(int[] arr) {
/*        // 演示第一轮
        // 首先将10个数据分成5组 每组两个元素 然后gap=5
        int temp = 0;
        for (int i = 5; i < arr.length; i++) {
            for (int j = i - 5; j >= 0; j-=5) {// 内循环要从j=0开始，j>=0  要到0  因为0索引是第一个位置
                if (arr[j + 5] < arr[j]) {
                    temp = arr[j + 5];
                    arr[j + 5] = arr[j];
                    arr[j] = temp;
                }
            }
        }*/
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap/=2) {
            for (int i = gap; i < arr.length; i++) {
                // 内循环的gap只会减一次 因为始终是除以2的 一组里面只有2个元素 开始的第一个循环是这样
                for (int j = i - gap; j >= 0; j-=gap) {// 内循环要从j=0开始，j>=0  要到0  因为0索引是第一个位置
                    if (arr[j + gap] < arr[j]) {
                        temp = arr[j + gap];
                        arr[j + gap] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }

    /**
     * 插入排序
     * @param arr
     */
    private static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {// for从1开始  第0号元素是有序的
            insertVal = arr[i];// 要进行插入的数
            insertIndex = i;// 要进行插入数的前一个索引 这个位置是要--的，是用来找合适位置的
            // while条件是 保证insetIndex不越界  并且要插入的数比前面的数小
            while (insertIndex - 1 >= 0 && insertVal < arr[insertIndex - 1]) {
                arr[insertIndex] = arr[insertIndex - 1];
                insertIndex --;
            }
            // 因为当while退出来之前inserIndex已经-1了 而要插入的位置在insertIndex处   举例即可理解
            if (insertIndex!= i) {// 优化!
                arr[insertIndex] = insertVal;
            }
        }
    }

    /**
     * 选择排序
     * 第i次大循环都是为了将第i个元素换成合适的    合适的意思就是  第2个元素位置就要放倒数第二小的
     * 优化部分：对第i个元素进行操作的时候 要判断该元素是不是已经是最小的了 如果是就不用再进行交换的了
     * @param arr
     */
    private static void selectSort(int[] arr) {
/*        // 第一轮 目的是把数组第一个元素换成最小的
        // 先假定第一个元素为最小的
        int minIndex = 0;
        int min = arr[0];
        // 然后从第二个元素位置开始遍历找
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        // 一个for之后 min 和 minIndex就表示最小的数和最小数的索引了  然后将其置为arr[0]和0
        // 要判断原先arr[0]是否就是最小的数 不是 才进行交换
        if (minIndex != 0) {
            arr[minIndex] = arr[0];
            arr[0] = min;
        }
        System.out.println("第"+0+"趟排序的结果是"+ Arrays.toString(arr));*/
        for (int i = 0; i < arr.length - 1; i++) {// 外面的大循环 第i次就表示要换的是第i个元素 把第i元素换成合适的
            int minIndex = i;
            int min = arr[i];
            // 然后从第二个元素位置开始遍历找
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 一个for之后 min 和 minIndex就表示最小的数和最小数的索引了  然后将其置为arr[0]和0
            // 要判断原先arr[0]是否就是最小的数
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第"+(i + 1)+"趟排序的结果是"+ Arrays.toString(arr));
        }
    }

    /**
     * 冒泡排序
     * 随着每次大循环 陆续将大的元素换到后面 第一大的元素就换到倒数第一的位置
     * 冒泡排序的优化：如果我们发现在某趟循环中没有进行一次交换，就可以提前结束冒泡排序！
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        int temp = 0;
        boolean flag =false;
        // 冒泡排序一共需要数组长度-1次大的循环
        // 每次大的循环都是交换相邻元素的大小
        for (int i = 0; i < arr.length - 1; i++) {// 数组长度-1次大的循环
            for (int j = 0; j < arr.length - 1 - i; j++) {// 第一次大的循环只需要循环数组长度减1次就够了，就能把最大的元素选出来
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (!flag) {// 这一大趟中一次交换都没有发生过，说明已经有序了
                break;// 跳出外面的大循环
            }else {
                flag = false;// 保证每次进入大循环时候都是false
            }
            // System.out.println("第"+(i+1)+"趟排序的结果是"+Arrays.toString(arr));
        }
    }
}
