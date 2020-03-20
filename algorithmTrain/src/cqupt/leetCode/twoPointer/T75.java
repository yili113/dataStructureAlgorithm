package cqupt.leetCode.twoPointer;

import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-03-09 15:35
 */
public class T75 {


    /**
     * 计数法
     * 统计 0 1 2三个数字分别出现的次数
     * 然后直接把原nums数组指定位置上的数改变即可
     * @param nums
     */
    public void sortColors(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                count0 ++;
            else if (nums[i] == 1)
                count1 ++;
        }
        for (int i = 0; i < count0; i++) {
            nums[i] = 0;
        }
        for (int i = count0; i < count0 + count1; i++) {
            nums[i] = 1;
        }
        for (int i = count0 + count1; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    /**
     * 双指针法
     * left指针左侧(不包含当前位置)全是0
     * right指针右侧(不包含当前位置)全是2
     * @param nums
     */
    public void sortColors1(int[] nums) {
        if (nums == null || nums.length < 1)
            return;
        int left = 0;
        int right = nums.length - 1;
        while (left < nums.length && nums[left] == 0) {
            left ++;
        }
        while (right >= 0 && nums[right] == 2)
            right --;
        // 此时left左侧全为0  right右侧全为2
        int index = left;
        while (index <= right) {
            if (nums[index] == 2) {// 此时index指向的数要与right指向的数交换
                swap(nums, index, right);
                right --;
            }else if (nums[index] == 0) {
                swap(nums, index, left);
                left ++;
                index ++;// 此处index++而nums[index] == 2时不进行index++：index从左到右遍历，
                // 不可能指向的是2，只能是1，交换之后index指向的是1，所以直接index++
                // 而right指向的可能是0或1，若指向0的时候交换了，index就指向0，
                // 若++则跳过了这个位置的判断(此时假定left指向1)
                /**
                 * 测试证明如果初始index=right的话就可以nums[index] == 2时加上index--
                 * 而nums[index] == 0时不能加index--
                 */
            }else // 遍历到的数是1的情况
                index ++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2,0,1};
        T75 t75 = new T75();
        t75.sortColors1(nums);
        System.out.println(Arrays.toString(nums));
    }
}
