package cqupt.leetCode.twoPointer;

/**
 * @author Liyi
 * @create 2020-03-02 11:10
 * 移除元素    原地修改输入数组
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
、
 *
 */
public class T27 {


    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 2));
    }

    /**
     * 慢指针指过的数都是需要的
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int low = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[low++] = nums[fast];
            }
        }
        return low;
    }
}
