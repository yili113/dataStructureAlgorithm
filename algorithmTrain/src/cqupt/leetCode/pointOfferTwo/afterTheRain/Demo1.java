package cqupt.leetCode.pointOfferTwo.afterTheRain;

/**
 * @author yiLi
 * @create 2020-07-15 14:55
 * 接雨水
 */
public class Demo1 {
    public int trap1(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int total = 0;
        int len = height.length;
        // 找每个位置最多能装多少水
        for (int i = 1; i < len - 1; i++) {// 从1开始,0位置肯定装不了水
            int leftMax = 0;
            int rightMax = 0;
            for (int j = 0; j <= i; j++) {// 找左右最高,必须包含当前自身的高度,假设自身高度比左右的都高,也接不了水
                leftMax = height[j] > leftMax ? height[j] : leftMax;
            }
            for (int j = i; j < len; j++) {
                rightMax = height[j] > rightMax ? height[j] : rightMax;
            }
            int curSum = Math.min(rightMax,leftMax) - height[i];
            total += curSum;
        }
        return total;
    }

    // 备忘录优化 记录每个位置左右最高的高度
    public static int trap2(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int len = height.length;
        int total = 0;
        int[] leftMaxArr = new int[len];// 左右侧最大高度包括自身的高度
        int[] rightMaxArr = new int[len];
        leftMaxArr[0] = height[0];
        int leftMax = height[0];
        rightMaxArr[len - 1] = height[len - 1];
        int rightMax = height[len - 1];
        for (int i = 1; i < len; i++) {
            leftMax = leftMax > height[i] ? leftMax : height[i];
            leftMaxArr[i] = leftMax;
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMax = rightMax > height[i] ? rightMax : height[i];
            rightMaxArr[i] = rightMax;
        }
        for (int i = 1; i < len - 1; i++) {
            int cur = Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
            total += cur;
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }

    // 双指针
    public static int trap3(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int total = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        while (left <= right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);// rightMax表示right---len-1(包括right)的最大值
            if (leftMax < rightMax) {
                total += leftMax - height[left];// leftMax表示0-left(包括left)的最大值
                left ++;
            }else {
                total += rightMax - height[right];
                right --;
            }
        }
        return total;
    }
}
