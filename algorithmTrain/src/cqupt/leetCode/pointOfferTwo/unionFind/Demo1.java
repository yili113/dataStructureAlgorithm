package cqupt.leetCode.pointOfferTwo.unionFind;

/**
 * @author yiLi
 * @create 2020-07-08 9:25
 * 朋友圈
 */
public class Demo1 {

    int[] FATHERS;
    int COUNT;
    public int findCircleNum(int[][] M) {
        // 1.首先声明一个父结点数组
        int n = M.length;
        FATHERS = new int[n];// n个孩子初始化n个父结点
        for (int i = 0; i < n; i++) {
            FATHERS[i] = i;// 初始化每个孩子的父结点都是自己
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {// i,j是朋友,合并朋友圈
                    union(i, j);
                }
            }
        }
        COUNT = 0;
        for (int i = 0; i < n; i++) {
            if (FATHERS[i] == i)
                COUNT ++;
        }
        return COUNT;
    }

    private void union(int i, int j) {
        int fatherI = find(i);
        int fatherJ = find(j);
        FATHERS[fatherI] = fatherJ;
    }
    // 找i的父结点
    private int find(int i) {
        while (FATHERS[i] != i)
            i = FATHERS[i];
        return i;
    }
}
