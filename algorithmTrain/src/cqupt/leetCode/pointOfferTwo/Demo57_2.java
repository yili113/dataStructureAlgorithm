package cqupt.leetCode.pointOfferTwo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-07-03 11:09
 * 和为s连续序列
 */
public class Demo57_2 {
    // 输入：target = 9
    // 输出：[[2,3,4],[4,5]]
    // 滑动窗口
    public static int[][] findContinuousSequence(int target) {
        int l = 1;
        int r = 1;
        int sum = 0;
        ArrayList<int[]> res = new ArrayList<>();
//        while (l <= target / 2) {
//            sum += r;
//            r ++;
//            while (sum == target) {
//                // 添加到一维数组
//                int[] cur = new int[r - l + 1];
//                for (int i = l; i <= r; i++) {
//                    cur[i - l] = i;
//                }
//                res.add(cur);
//                sum -= l;
//                l ++;
//            }
//        }
        while (l <= target / 2) {
            if (sum < target) {
                r ++;
                sum += r;
            }else if (sum > target) {
                l ++;
                sum -= l;
            }else {
                int[] cur = new int[r - l];
                for (int i = l; i < r; i++) {
                    cur[i - l] = i;
                }
                res.add(cur);
                l ++;
                sum -= l;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] res = findContinuousSequence(9);
        for(int[] ints : res) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
