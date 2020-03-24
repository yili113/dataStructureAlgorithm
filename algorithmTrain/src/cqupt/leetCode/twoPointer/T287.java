package cqupt.leetCode.twoPointer;

/**
 * @author Liyi
 * @create 2020-03-22 14:49
 * 寻找重复数---快慢指针
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），
 * 可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数.
 *
 * 上述题意：n+1个数全都是1-n之间的,并且其中有一个数是重复的,这就意味着由下标表示当前结点,
 * val表示下一结点构成的数组中,一定能构成环,并且重复的那个数就是环的入口
 */
public class T287 {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (true) {
            // 下一步到的位置就是当前步对应数组下标的值
            fast = nums[nums[fast]];// 表示fast指针每次都两步
            slow = nums[slow];// slow只恨每次都一步
            if (fast == slow) {// 第一次相遇
                fast = nums[0];// fast指针回到数组开头
                while (fast != slow) {
                    fast = nums[fast];// fast和slow每次走一步
                    slow = nums[slow];
                }
                // 此时两指针第二次相遇
                return slow;
            }
        }
    }
}
