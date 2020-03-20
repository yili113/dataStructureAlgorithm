package cqupt.leetCode.binaryCase;

/**
 * @author Liyi
 * @create 2020-03-08 15:52
 */
public class T69 {

    /**
     * 二分法求平方根
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        int maxValue = (int) Math.sqrt(Integer.MAX_VALUE);// 先从最大数的平方根开始试
        int left = 0;
        int right = maxValue;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (mid * mid == x)
                return mid;
            else if (mid * mid > x)
                right = mid;
            else
                left = mid;
        }
        if (right * right <= x)
            return right;
        else
            return left;
    }
}
