package cqupt.leetCode.pointOfferThree.netEase;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-08 12:32
 * 篮球队
 */
public class Demo6 {
    static int COUNT;
    static int sumA;
    static int sumB;
    static int minA;
    static int preMinA;

    public static void main(String[] args) {
        COUNT = 0;
        minA = Integer.MAX_VALUE;
        preMinA = Integer.MAX_VALUE;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = sc.nextInt();
        }
        sc.close();
        helper(scores, 0);
        System.out.println(COUNT);
    }

    private static void helper(int[] scores, int index) {
        if (index == scores.length && sumA > sumB && (sumA - minA) < (sumB + minA)) {
            COUNT ++;
        }else if (index == scores.length) {

        } else {
            // 选当前的元素到A队
            if (scores[index] < minA) {
                minA = scores[index];
                preMinA = minA;
            }
            sumA += scores[index];
            helper(scores, index + 1);
            // 回溯
            sumA -= scores[index];
            minA = preMinA;


            // 不选当前元素到A队,选去B队
            sumB += scores[index];
            helper(scores, index + 1);
        }
    }
}
