package cqupt.leetCode.stack;

/**
 * @author Liyi
 * @create 2020-03-25 13:33
 * 每日温度
 */
public class T739 {
    // 垃圾解法
    public int[] dailyTemperatures1(int[] T) {
        int n = T.length;
        int[] gap = new int[n];
        if (T == null || n == 0)
            return gap;
        for (int i = 0; i < T.length - 1; i++) {
            for (int j = i + 1; j < T.length; j++) {
                if (T[j] > T[i]) {
                    gap[i] = j - i;
                    break;
                }else
                    gap[i] = 0;
            }
        }
        gap[n - 1] = 0;
        return gap;
    }
}
