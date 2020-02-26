package cqupt.algorithm.graphAlgorithm;


import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-02-26 13:49
 * prim算法 求最小生成树
 */
public class Prim {
    /**
     *  prim是根据结点来的
     * 首先确定一个起始的结点 然后顺着这个结点往下找
     */
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        // 邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {10000,5,7,10000,10000,10000,2},
                {5,10000,10000,9,10000,10000,3},
                {7,10000,10000,10000,8,10000,10000},
                {10000,9,10000,10000,10000,4,10000},
                {10000,10000,8,10000,10000,5,4},
                {10000,10000,10000,4,5,10000,6},
                {2,3,10000,10000,4,6,10000},};

        // 创建MGraph对象
        MGraph graph = new MGraph(verxs);
        // 创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        // 输出
        minTree.showGraph(graph);
        // 测试普利姆算法
        minTree.prim(graph, 0);//
    }

}
/**
 * 创建最小生成树
 */
class MinTree {
    /**
     * 创建图的邻接矩阵
     * 邻接矩阵就能代表一个图，就跟一个头结点就能代表链表一样
     * @param graph
     * @param verxs 结点个数
     * @param data 结点标号
     * @param weight 权值
     */
    public void createGraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i, j;
        for(i = 0; i < verxs; i++) {//顶点
            graph.data[i] = data[i];
            for(j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    // 显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for(int[] link: graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * prim算法
     * @param graph
     * @param o 初始结点i  'A'-->0  'B'-->1
     */
    public void prim(MGraph graph, int o) {
        // 定义一个标记结点是否访问过的数组
        boolean[] visited = new boolean[graph.verxs];
        // 标记初始结点被访问过
        visited[o] = true;
        // 定义两个变量 用来标记表示一条边的两个结点
        int h1 = -1;
        int h2 = -2;
        // 定义最小权值的初始值
        int minWeight = 10000;
        // 从1开始遍历：遍历次数是存下来边的条数 是比结点数少1
        for (int k = 1; k < graph.verxs; k++) {
            // 用来遍历已被访问过的结点
            for (int i = 0; i < graph.verxs; i++) {// 这层for 每次都从第一个结点开始循环有个用意就是：每次都要重复考虑标记过的结点
                // 可能 A B 都被标记，但是A的某一邻接边更小一些
                // 用来遍历未被访问过的结点
                for (int j = 0; j < graph.verxs; j++) {
                    // 当i结点被访问过，j结点未被访问过时候 在判断该边的权值，不断循环这两层for 找到最小的权值
                    if (visited[i] == true && visited[j] == false && graph.weight[i][j] < minWeight) {
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            // 输出最小的边  在最外层for里  会输出最终边的个数
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            // 要把h2指向的结点标记为访问过
            visited[h2] = true;
            // 重置最小minWeight  每次找边的时候都要重置
            minWeight = 10000;
        }
    }
}

/**
 * 图的创建
 */
class MGraph {
    int verxs; // 表示图的节点个数
    char[] data;// 存放结点数据
    int[][] weight; // 存放边，就是我们的邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}