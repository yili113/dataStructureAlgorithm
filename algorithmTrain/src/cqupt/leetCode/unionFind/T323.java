package cqupt.leetCode.unionFind;

/**
 * @author Liyi
 * @create 2020-04-16 21:35
 * 无向图中连通分量的数目
 */
public class T323 {
    /**
     *
     * @param n n个结点 编号为 0 - n-1
     * @param edges 边 由两端结点表示
     * @return
     */
    public int countComponents(int n, int[][] edges) {
        if (n == 0 || edges == null)
            return 0;
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        int count = 0;
        // 以下代码错误地想成根据边来union
//        for (int i = 0; i < edges.length - 1; i++) {// [[0, 1], [1, 2], [2, 3], [3, 4]]
//            for (int j = i + 1; j < edges.length; j++) {
//                if (edges[i][0] == edges[j][0] || edges[i][0] == edges[j][1] ||
//                        edges[i][1] == edges[j][0] || edges[i][1] == edges[j][1]) {
//                    union(i, j);
//                }
//            }
//        }
        for (int i = 0; i < edges.length; i++) {// 对每个结点进行合并,同一条边上的两个结点合并一起,拥有共同的群体father
            union(edges[i][0], edges[i][1]);
        }
        // 统计群体数
        for (int i = 0; i < n; i++) {
            if (father[i] == i)// 找每个结点的father,判断集体数
                count ++;
        }
        return count;
    }

    private void union(int i, int j) {
        int f1 = find(i);
        int f2= find(j);
        father[f2] = f1;
    }

    private int find(int i) {
        while (father[i] != i)
            i = father[i];
        return i;
    }

    private static int[] father;

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {0,2}, {3, 4}};
// [[0,1],[1,2],[0,2],[3,4]]
        T323 t323 = new T323();
        System.out.println(t323.countComponents(n, edges));
    }
}
