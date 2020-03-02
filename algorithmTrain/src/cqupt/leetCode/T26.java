package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-02 10:54
 删除排序数组中的重复项
 要求必须在原数组中进行修改！
 */
public class T26 {

    public static void main(String[] args) {

    }

    /**
     * low指针一直需要被调换的那个位置，fast指向正在判断的位置
     * 当nums[fast] == nums[fast - 1]时，慢指针是不动的 因为慢指针指过的数都是不重复的
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int low = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[low] = nums[fast];
                low ++;
            }
        }
        return low;
    }
}
