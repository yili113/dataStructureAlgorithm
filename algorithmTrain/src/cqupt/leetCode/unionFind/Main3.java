package cqupt.leetCode.unionFind;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-22 15:57
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] weights = new int[n + 1];
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            weights[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        sc.close();
        ArrayList<HashMap<Integer, Integer>> list = new ArrayList<>();
        boolean[] booleans = new boolean[n + 1];// 为false就说明没有被取走
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int cur = nums[i];// 当前取出的编号
            if (booleans[cur])
                continue;
            int leftSum = 0;
            int rightSum = 0;
                for (int j = 1; j <= cur - 1; j++) {
                    if (booleans[j])// 为true就说明取走了
                        continue;
                    leftSum += weights[j];
                }
                for (int k = cur + 1; k <= n; k++) {
                    if (booleans[k])
                        continue;
                    rightSum += weights[k];
                }
            res.add(Math.max(leftSum, rightSum));
            booleans[cur] = true;
        }
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
