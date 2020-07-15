package cqupt.leetCode.binaryCase;

/**
 * @author yiLi
 * @create 2020-07-15 11:02
 * 在D天内送达包裹的能力
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 *
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
**/
public class Demo1011 {

    public int shipWithinDays(int[] weights, int D) {
        int min = getMin(weights);
        int max = getMax(weights);
        int left = min;
        int right = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canFinished(weights, mid, D))
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }

    // 判断每天运minWeight,d天内能够运完weights中所有重量
    private boolean canFinished(int[] weights, int minWeight, int d) {
        int index = 0;// 记录weights的下标
        int capcity = 0;
        for (int i = 1; i <= d; i++) {
            capcity = minWeight;
//            while (capcity - weights[index] > 0) { // 此处要是>=0  ==0时候当前那个index值也是可用的
//                capcity -= weights[index];
//                index ++;
//                if (index == weights.length)
//                    return true;
//            }
            while ((capcity -= weights[index]) >= 0) {
                index ++;
                if (index == weights.length)
                    return true;
            }
        }
        return false;
    }

    // 载物的最大重量是  所有的货物一起运完  就是weights的和
    private int getMax(int[] weights) {
        int sum = 0;
        for (int num : weights)
            sum += num;
        return sum;
    }

    // 载物的最小重量 weights中的最大值(运一次)
    // 如果不选择weights中的最大值就会导致weights中有些重量货物不能运
    private int getMin(int[] weights) {
        int max = Integer.MIN_VALUE;
        for (int num : weights)
            max = num > max ? num : max;
        return max;
    }
}
