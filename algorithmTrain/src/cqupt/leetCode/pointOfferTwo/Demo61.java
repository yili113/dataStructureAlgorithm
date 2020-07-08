package cqupt.leetCode.pointOfferTwo;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yiLi
 * @create 2020-07-07 9:10
 * 扑克牌中的顺子
 * 大小王为0 可以充当任意数字
 */
public class Demo61 {
    // 将数组排序后,不断用0的数量去填充元素间的差值
    public boolean isStraight1(int[] nums) {
        int zeroNums = 0;
        for (int num : nums)
            if (num == 0)
                zeroNums ++;
        Arrays.sort(nums);
        for (int i = zeroNums + 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])// 连续两张牌相同肯定不能构成顺子
                return false;
            zeroNums -= nums[i] - nums[i - 1] - 1;
            if (zeroNums < 0)
                return false;
        }
        return true;
    }

    // 通过set判断有无重复元素
    // 并且牌中最大最小值的差值<5就说明是顺子,因为已经知道无重复元素,又差值小于5
    // 就说明牌中各个元素都是有用的,能构成顺子的,就算有0也能用掉
    public boolean isStraight2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num == 0)
                continue;
            max = num > max ? num : max;
            min = num < min ? num : min;
            if (set.contains(num))// 判断有无重复元素
                return false;
            set.add(num);
        }
        return max - min < 5;
    }
}
