package cqupt.leetCode.binaryCase;

/**
 * @author yiLi
 * @create 2020-07-15 10:33
 */
public class Demo875 {
    // 输入: piles = [30,11,23,4,20], H = 5
    // 输出: 30

    // 输入: piles = [30,11,23,4,20], H = 6
    // 输出: 23

    // 可选的吃香蕉速度范围:1-max(piles)
    // 最慢可以1小时吃一根
    // 最快可以1小时吃最大的那一堆数量
    public int minEatingSpeed(int[] piles, int H) {
        int maxNum = getMax(piles);
        int left = 1;
        int right = maxNum;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinished(piles, mid, H)) {
                right = mid - 1;// 找最小的速度,向左逼近
            }else
                left = mid + 1;
        }
        return left;
    }
    // 判断speed速度在h时间内能否吃完piles内的香蕉
    private boolean canFinished(int[] piles, int speed, int h) {
        int times = 0;
        for (int num : piles) {
            int time = timeOf(num , speed);
            times += time;
        }
        return times <= h;
    }

    private int timeOf(int total, int speed) {
        return total % speed > 0 ? total / speed + 1 : total / speed;
    }

    private int getMax(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int num : piles)
            max = num > max ? num : max;
        return max;
    }
}
