package cqupt.writtenExamination.youZan;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-09-11 15:16
 */
public class Main2 {
    public static int minMoves (int[] nums) {
        // write code here
        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int count = 0;
        for (int num : nums)
            count += Math.abs(num - mid);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        System.out.println(minMoves(nums));
        ArrayList<String[]> list = new ArrayList<>();
    }
}
