package cqupt.leetCode.twoPointer;

/**
 * @author Liyi
 * @create 2020-04-30 10:02
 * 快乐数
 */
public class T202 {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = squareSum(n);
        // 只要slow能等于fast就说明成环,因为fast跑得快,slow跑得慢,不成环的话就一直追不上
        while (slow != fast) {
            slow = squareSum(slow);
            fast = squareSum(squareSum(fast));
        }
        return slow == 1;
    }

    /**
     * 计算一个数的各个位上数平方的和
     * @param n
     * @return
     */
    public int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

}
