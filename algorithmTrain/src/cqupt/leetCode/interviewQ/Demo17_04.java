package cqupt.leetCode.interviewQ;

/**
 * @author yiLi
 * @create 2020-06-17 9:25
 * 寻找消失的元素-- 只有一个元素丢失
 */
public class Demo17_04 {
    public int missingNumber1(int[] nums) {
        // [3, 0, 1] -- 2
        int[] newArr = new int[nums.length + 1];
        // 把所有的索引和元素进行异或
        for (int i = 0; i < nums.length; i++) {
            newArr[i] = nums[i];
        }
        int sum = 0;
        for (int i = 0; i < newArr.length; i++) {
            sum ^= (newArr[i] ^ i);
        }
        return sum;
    }

    // 不用额外空间  异或运算  将元素与下标异或
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        sum ^= n;// 首先把补的索引异或一下
        for (int i = 0; i < n; i++) {
            sum ^= (i ^ nums[i]);
        }
        return sum;
    }

    // 通过等差数列
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int excpetSum = n * (n + 1) / 2;
        int sum = 0;
        for (int num : nums)
            sum += num;
        return excpetSum - sum;
    }

    // 依次将元素与下标想减 得到最后的差的累加
    public int missingNumber3(int[] nums) {
        int n = nums.length;
        int sum = 0;
        sum += n;
        for (int i = 0; i < n; i++) {
            sum += (i - nums[i]);
        }
        return sum;
    }
}