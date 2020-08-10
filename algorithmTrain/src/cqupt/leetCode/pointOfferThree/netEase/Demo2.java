package cqupt.leetCode.pointOfferThree.netEase;

import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-08-07 10:16
 * 分贝壳
 */
public class Demo2 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        System.out.println(solution(n));
    }

    // 二分查找
    private static int solution(int n) {

        int l = 1;
        int r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;// 表示m的值 二分去找
            if (isOk(n, mid))
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    // n表示贝壳总数,m表示妞妞取的贝壳数
    private static boolean isOk(int n, int m) {
        int res = n;// 每次进这个方法剩下的贝壳数
        int totalNIU = 0;// 妞妞获得的总数
        int totalniu = 0;
        int cur = 0;
//        while (res >= m) {
//            totalNIU += m;
//            res -= m;
//            if (res > 0) {// 牛牛再分
//                cur = res / 10;
//                totalniu += cur;
//                res -= cur;
//            }
//        }
        while (res > 0) {
            if (res <= m) {
                totalNIU += res;
                res = 0;
            }else {
                totalNIU += m;
                res -= m;
            }
            res -= res / 10;
        }
        return totalNIU >= n / 2;
    }
}
