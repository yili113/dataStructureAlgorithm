package cqupt.leetCode.pointOfferTwo.afterTheRain;

/**
 * @author yiLi
 * @create 2020-07-15 16:03
 * 盛水最多的容器
 * 与接雨水不同的是:此题需要找到最大的接水量
 * 只需要找到左右边界,然后计算边界中间的水量
 * 不断更新最大值
 */
public class Demo2 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int maxArea = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left <= right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[right], height[left]));
            if (height[left] < height[right])// 对于这种情况,高度有height[left]决定,如果左移right
                left ++;// height[right-1]>height[right],这时候高度还是由height[left]决定,height[right-1]<height[right]就更小了
            else if (height[left] > height[right])
                right --;
            else if (height[left] == height[right]) {// height[left] == height[right]时候只移动left或者right是不会增大面积的
                left ++;
                right --;
            }
        }
        return maxArea;
    }
}
