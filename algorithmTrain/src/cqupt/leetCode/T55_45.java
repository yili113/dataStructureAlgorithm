package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-12 17:06
 * 跳跃游戏1----判断能否到达队尾
 *
 * 跳跃游戏2----使用最少的次数跳到队尾
 */
public class T55_45 {
    /**
     * 思路： 计算nums中的每个元素位置接下来能达到的最远的位置
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length < 2)
            return true;
        int reach = 0;
        for (int i = 0; i < nums.length && i <= reach; i++) {// i<=reach--遍历的下标i必须是能到达的
            reach = Math.max(nums[i] + i, reach);// nums[i] + i--对于下标为i的数组位置能达到的最大位置 本身位置就是i
            if (reach >= nums.length - 1)// 如果能达到的最大位置>=数组末尾元素位置  就是true
                return true;
        }
        return false;
    }

    /**
     * 跳跃游戏2
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        int curMax = 0;
        int nextMax = 0;
        int step = 0;
        int index = 0;
        while (index <= curMax) {// 如果index=6而curMax=5就要出大while 表明最大可到达不是队尾
            while (index <= curMax) {
                nextMax = Math.max(nextMax, index + nums[index]);
                index ++;
            }
            // 出了小while就要重新赋值curMax
            curMax = nextMax;
            step ++;
            if (curMax >= nums.length - 1)
                return step;
        }
        // 如果出了大while就说明到不了队尾
        return 0;
    }
}
