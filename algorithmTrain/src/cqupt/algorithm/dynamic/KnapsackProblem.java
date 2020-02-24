package cqupt.algorithm.dynamic;

/**
 * @author Liyi
 * @create 2020-02-24 13:28
 * 01背包问题
 */
public class KnapsackProblem {
    /**
     * 1.先遍历商品种类，再遍历重量  是根据价值来遍历
     * 2.v[i][j]表示前i个商品中能装入容量为j的背包的最大价值
     * 3.v[i][0] = v[0][j] = 0;
     * 4.当w[i] > j时， v[i][j] = v[i - 1][j]  当装入新的商品的时候却发现w[i]大于j，根本不可能放进去
     * 价值还为之前的价值
     * 5.w[i] <= j时， 此时尝试装第i个物品(因为这个商品可以放，哪怕把之前放的拿出来，也要试一下)
     * v[i][j] = max{v[i-1][j]， v[i-1][j-w[i]]+v[i]}
     * j-w[i]表示让j减去i物品的重量，看剩余的重量怎么装，先减掉的原因是后面要加上v[i],(这个情况默认第i个商品加上去)
     * v[i-1][j-w[i]]表示前i-1个商品在j-w[i]重量下的最大价值
     */
    public static void main(String[] args) {
        // 把下述两个数组第一个元素置为0  方便写代码
        int[] w = {0, 1, 4, 3};
        int[] val = {0, 1500, 3000, 2000};
        int m = 4;// 背包的容量
        int n = val.length;

        // 创建二维数组
        int[][] v = new int[n][m+1];// v[i][j]表示前i个商品中能装入容量为j的背包的最大价值
        // 为了记录放入商品的情况
        int[][] path = new int[n][m+1];
        // 没有物品或者没有重量时  价值肯定为0
        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }
        // 上述公式的改写
        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i] > j) {
                    v[i][j] = v[i-1][j];
                }else {
//                    v[i][j] = Math.max(v[i-1][j], v[i-1][j-w[i]]+val[i]);
                    // 为了记录如何存放 要用path路径
                    if (v[i-1][j] < v[i-1][j-w[i]]+val[i]) {
                        v[i][j] = v[i-1][j-w[i]]+val[i];
                        path[i][j] = 1;// 此时需要注意：记录路径是记录最优的值是怎么得到的，只有又最优质的出现时
                        // 才记录，也就是说当商品i能加进来改变了v[i][j]时记录
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }
//        System.out.println(v[v.length-1][v[0].length-1]);
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
/*        // 这样输出有冗余的数据 我们只需要最后的放入情况
        for (int i = 0; i < path.length; i++) {
            for (int j = 0; j < path[0].length; j++) {
                if (path[i][j] == 1) {
                    System.out.printf("第%d个商品放入背包\n", i);
                }
            }
        }*/
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0){// 从后往前找找到最后面满足的那个
            if (path[i][j] == 1) {
                System.out.printf("第%d个商品放入背包\n", i);
                j -= w[i];// !!!这里是当发现i放入过  就要在j中把i的重量减去 这样才能保重j一直在减小
                // 再看剩下的j放了哪个商品
            }
            i --;
        }
    }
}
