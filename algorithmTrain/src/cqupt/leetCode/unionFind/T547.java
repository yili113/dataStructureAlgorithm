package cqupt.leetCode.unionFind;

/**
 * @author Liyi
 * @create 2020-03-17 22:24
 * 朋友圈---并查集---找连通的问题---本题是基础版本，模板
 * 先假设A是一个群体，B是一个群体，如果发现A和B是好朋友的话就把两个群体合成一个
 * 用一个father[i]表示i所在群体的代表。
 */
public class T547 {
    static int[] father;
    static int[] ranks;
    public int findCircleNum(int[][] M) {
        int n = M.length;
        if (n == 0)
            return 0;
        // 1.假设每个元素开始都是一个单独的群体
        father = new int[n];
        ranks = new int[n];
        for (int i = 0; i < n; i++) {// 开始每个单独群体的代表就是自己
            father[i] = i;
            ranks[i] = 1;// 初始化每个群体的秩都为1
        }
        // 2.查询原二维数组中谁和谁是好朋友 然后进行合并它们各自的群体           矩阵是对称的,只需要查右上角即可
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < n; j++) {
                if (M[i][j] == 1) {
                    uni(i , j);// 合并i,j为代表的两个群体
                }
            }
        }
        // 3.查找一共有多少个群体 当i的代表是本身的时候就是一个群体
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (father[i] == i)
                count ++;
        }
        return count;
    }

    /**
     * 合并i,j所在的的两个群体
     * @param i
     * @param j
     */
    private void uni(int i, int j) {
        int f1 = find(i);
        int f2 = find(j);
//        father[f1] = f2;//将f1所在群体的代表置为f2  两个群体共用一个代表--实现合并
        if (ranks[f1] == ranks[f2]) {// 两个群体的秩相同，谁挂在谁下面都无所谓
            father[f2] = f1;
            ranks[f1] ++;
        }else if (ranks[f1] > ranks[f2]) {// 此时f1的群体大于f2的  f2挂在f1下面  此时f1的rank不会在增加
            father[f2] = f1;
        }else {
            father[f1] = f2;
        }
    }

    /**
     * 找到i所在群体的代表
     * @param i
     * @return
     */
    private int find(int i) {
        while (father[i] != i)// i为其所在群体的代表的表现是：father[i]=i.因为初始化就是这样，后续操作中要是合并了群体会更改father[i]
            i = father[i];// 递归查找
        return i;
    }
}
