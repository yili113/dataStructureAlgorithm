package cqupt.leetCode;

import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-03-12 16:07
 * 下一个排列
 *
 * 教训；
 * 当一个while里面套if语句的时候  里面不光要写if时候的逻辑
 * 还要写else时候的逻辑 不然当能进while时候却不是if就卡死循环在while里面
 * 不然就简写成进入while的条件是  原while的条件 + if的条件
 */
public class T31 {
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        // 1.先找需要被替代的数的位置
        // 从后往前找 找到一个前面的数比后面的数小的  就可以替换
        int replace = nums.length - 2;// 从倒数第二位开始找
        while (replace >= 0) {
            /**
             * 下面代码是错的
             */
//            if (nums[replace] >= nums[replace + 1])
//                replace --;
            if (nums[replace] < nums[replace + 1])
                break;
            replace --;
        }
        if (replace < 0) {// 如果能到这一步就说明原数组是从大到小排列的
            Arrays.sort(nums);
            return;
        }
        // 此时replace上的数比replace+1上的数要小，但不晓得跟replace+1后面那些数大小什么关系
        // 2.从replace开始往后找 找到一个比replace大 但是在比replace大的数中跟replace最接近的那个
        // 此时replace后面的数是从大到小排序好的---找replace的过程导致
        int larNum = replace + 1;
        /**
         * 下面代码是错误的写法
         * 假如说 la
         */
//        while (larNum < nums.length) {
//            if (nums[larNum] > nums[replace])
//                larNum ++;
//        }
        while (larNum < nums.length && nums[larNum] > nums[replace]) {
            larNum ++;
        }
        // 此时larNum指向的是<=replace的数
        // 所以larNum-1就是比replace数大而且是跟其最接近的数
        // 3.交换replace和larNum上的元素
        int temp = nums[replace];
        nums[replace] = nums[larNum - 1];
        nums[larNum - 1] = temp;
        // 4.将replace后面的数从小到大排序 保证是下一个排列
        Arrays.sort(nums, replace + 1, nums.length);// !!!这个方法是左包含右不包含的  i下标元素要进行排序 最后一参数要是i+1
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
