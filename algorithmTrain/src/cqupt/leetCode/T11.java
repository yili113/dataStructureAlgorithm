package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-01 12:47
 * 盛最多水的容器
 */
public class T11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
//        int[] height = {1, 2, 4, 3};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
    }

    /**
     * 思路1：暴力
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        if (height.length <= 1)
            return 0;
        if (height.length == 2)
            return Math.min(height[0], height[1]);
        int maxArea = 0;
        for (int i = 0; i < height.length - 2; i++) {
            for (int j = height.length - 1; j > i ; j--) {
                int minHeight = Math.min(height[i], height[j]);
                int curArea = minHeight * Math.abs(j - i);
                if (curArea > maxArea)
                    maxArea = curArea;
            }
        }
        return maxArea;
    }

    /**
     * 左右两个指针，每次只移动小的那个指针
     * 因为：假设此时height[left] < height[right],如果挪动right，分三种情况，1)right左边那个比right大，那么移动后的面积还是按照left
     * 指向的高度算，并且长还变短了，面积肯定变小。2)right左边那个比right小但是比left指向的大，此时还是按照left算高度
     * 3)right左边那个比right小而且比left指向的也小，此时高度按照right移动后的算，这样高度减小了，长也减小，面积肯定较小
     * 所以只能挪动left(数值大的那个指针)
     *
     * 当左右指针指向的数值相同时，同时移动两个指针，因为此时只挪动一个指针面积肯定变小
     * 只有同时挪动，面积才可能增大
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            maxArea = Math.max(maxArea, (right - left) * Math.min(height[left], height[right]));// 取比较大的面积
/*            if (height[left] < height[right])
                left ++;
            if (height[left] > height[right])
                right --;
            if (height[left] == height[right]) {
                left ++;
                right --;
            }*/
// 上面这种写法是 每个if都会执行一遍，下面这种写法是三种情况只会执行一种情况
            if (height[left] < height[right]) {
                left ++;
            }else if (height[left] > height[right]) {
                right --;
            }else {
                left ++;
                right --;
            }
        }
        return maxArea;
    }
}
