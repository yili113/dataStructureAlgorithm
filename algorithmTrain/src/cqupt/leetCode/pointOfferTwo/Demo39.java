package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-28 14:37
 */
public class Demo39 {
    // [1, 2, 3, 2, 2, 2, 5, 4, 2]
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        int votes = 0;// 当前众数的票数
        int x = 0;// 当前指定的众数
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0)
                x = nums[i];
            votes = x == nums[i] ? votes + 1 : votes - 1;
        }
        return x;
    }
}
