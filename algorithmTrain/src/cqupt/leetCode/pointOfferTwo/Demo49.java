package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-07-01 14:49
 */
public class Demo49 {
    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];// 记录最终的丑数序列
        int a = 0;
        int b = 0;
        int c = 0;
        dp[0] = 1;// 第一个丑数是1
        int an = 0;
        int bn = 0;
        int cn = 0;
        for (int i = 1; i < n; i++) {
            an = dp[a] * 2;
            bn = dp[b] * 3;
            cn = dp[c] * 5;
            dp[i] = Math.min(an,Math.min(bn,cn));// 选取三者中的最小值
            if (dp[i] == an)
                a ++;
            if (dp[i] == bn)// 此处不能写成else if 后面写else if的话就三者只能执行一者  万一有an bn cn存在相同的情况
                // 就会漏掉一些情况
                b ++;
            if (dp[i] == cn)
                c ++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }
}
