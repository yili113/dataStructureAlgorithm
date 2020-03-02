package cqupt.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Liyi
 * @create 2020-03-02 16:07
    三数之和
 */
public class T15 {

    // [-1,0,1,2,-1,-4]

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        T15 t15 = new T15();
        List<List<Integer>> lists = t15.threeSum(nums);
        System.out.println(lists);
    }

    /**
     * base left right三个指针只能指向相同数一次，下次再遇到就要跳过
     * [-4, -1, -1, 0, 1, 2]假如说base把两个-1都指向了 就会出现相同的集合
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if (nums  == null || nums.length < 3)
            return lists;
        Arrays.sort(nums);
        int base = 0;
        while (base < nums.length - 2) {
            int left = base + 1;
            int right = nums.length - 1;
            int baseVal = nums[base];
            while (left < right) {
                int sum = baseVal + nums[left] + nums[right];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(baseVal);
                    list.add(nums[left]);
                    list.add(nums[right]);

                    lists.add(list);
                    right = moveLeft(nums, right - 1);
                    left = moveRight(nums, left + 1);


                }else if (sum > 0) {
                    right = moveLeft(nums, right - 1);
                }else {
                    left = moveRight(nums, left + 1);
                }
            }
            base = moveRight(nums, base + 1);
        }
        return lists;
    }

    /**
     * left = moveRight(nums, left + 1)
     * 传进来参数是left的右侧（下一个）！！！！  也就是说下一个left
     * 这个方法就是判断left指向的下一个是不是合格的，是不是重复的
     * 重复的就会 left++, 直到找到不重复的
     * @param nums
     * @param left
     * @return
     */
    private int moveRight(int[] nums, int left) {// 右移方法是针对 左指针的，只有左指针才会右移
        while (left == 0 || (left < nums.length && nums[left] == nums[left - 1]))// left < nums.length防止移动时候越界
            left ++;
        return left;
    }

    private int moveLeft(int[] nums, int right) {// 左移方法是专门针对右指针的
        while (right == nums.length - 1 || (right >= 0 && nums[right] == nums[right + 1]))
            right --;
        return right;
    }


}
