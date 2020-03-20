package cqupt.leetCode.twoPointer;

/**
 * @author Liyi
 * @create 2020-03-20 21:46
 * 移动0---把0放到数组最后面---双指针
 * 双指针可以原地修改，只是在原数组交换元素
 */
public class T283 {
    public void moveZeroes(int[] nums) {
        int low = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[low];
                nums[low] = nums[fast];
                nums[fast] = temp;
                low ++;
            }
        }
    }
}
