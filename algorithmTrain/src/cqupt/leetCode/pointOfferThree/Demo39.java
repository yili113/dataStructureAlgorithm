package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-26 13:03
 * 数组中出现次数超过一半的数字
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */
public class Demo39 {
    // 投票选举
    public int majorityElement(int[] nums) {
        int votes = 0;
        int voteNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (votes == 0) {
                voteNum = nums[i];
            }
            votes = voteNum == nums[i] ? votes + 1 : votes - 1;
        }

        return voteNum;
    }
}
