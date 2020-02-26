package cqupt.algorithm.graphAlgorithm;

import java.util.Arrays;

/**
 * @author Liyi
 * @create 2020-02-26 15:07
 * Kruskal算法（选边）
 */
public class Kruskal {

    private int edgeNum; // 边的个数
    private char[] vertexs; // 顶点数组
    private int[][] matrix; // 邻接矩阵
    // 使用 INF 表示两个顶点不能连通
    private static final int INF = Integer.MAX_VALUE;

    /**
     * 构造器 初始化  结点，邻接矩阵和一共有的边数
     * @param vertexs
     * @param matrix
     */
    public Kruskal(char[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;
        // 需要统计多少条边
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {// j从i+1开始表示不统计自己到自己这条边
                if (this.matrix[i][j] != INF)
                    edgeNum ++;
            }
        }
    }
    // 打印邻接矩阵
    public void print() {
        System.out.println("邻接矩阵为: \n");
        for(int i = 0; i < vertexs.length; i++) {
            for(int j = 0; j < vertexs.length; j++) {
                System.out.printf("%12d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * 使用冒泡排序对所有的边进行排序
     * @param edges
     */
    public void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - i - 1; j++) {
                if(edges[j].weight > edges[j+1].weight) {// 交换
                    EData tmp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = tmp;
                }
            }
        }
    }

    /**
     * 根据结点字符返回该结点的下标
     * @param vertx
     * @return
     */
    public int getPosition(char vertx) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertx == vertexs[i])
                return i;
        }
        return -1;
    }

    /**
     * 得到所有边的一个数组
     * @return
     */
    public EData[] getEdges() {
        EData[] edges = new EData[edgeNum];
        int index = 0;
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != INF) {
                    edges[index] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                    index ++;
                }
            }
        }
        return edges;
    }

    /**
     * 得到下标为i的结点的终点下标
     * @param ends 存放各个顶点的终点下标 是一个动态生成的数组
     * @param i i结点
     * @return i结点的终点
     */
    public int getEnds(int[] ends, int i) {
        while (ends[i] != 0) {
            // 递归的过程 ends[i]表示i的终点，如果ends[i]！=0，
            // 就表示i有终点，就i=ends[i],一直递归到终点
            i = ends[i];
        }
        return i;
    }

    /**
     * 核心算法
     */
    public void kruskal() {
        int index = 0;// 表示最后结果数组的索引
        int[] ends = new int[edgeNum];// 表示每个顶点的终点的数组，动态生成的
        EData[] res = new EData[edgeNum];// 存放选进最小生成树的边
        EData[] edges = getEdges();// 原始图中的所有边
        System.out.println("图的边的集合=" + Arrays.toString(edges) + " 共"+ edges.length); //12
        sortEdges(edges);// 对原始的边按照权值进行排序
        // 遍历edges数组，开始选边。按照权值从小到大开始选，不构成回路就可以入选，放入res数组中
        for (int i = 0; i < edgeNum; i++) {
            // 得到某条边的起点
            int p1 = getPosition(edges[i].start);
            // 得到某条边的终点
            int p2 = getPosition(edges[i].end);
            // 得到该边两端结点的终点
            int ends1 = getEnds(ends, p1);
            int ends2 = getEnds(ends, p2);
            // 判断是否构成回路
            // 如果不构成回路，说明这条边可以入选，将这条边放入到res数组，然后将p1的终点设置为p2
            if (ends1 != ends2) {
//                ends[p1] = p2;
                ends[ends1] = ends2;// TODO
                res[index ++] = edges[i];// res数组的索引不断增加
            }
        }
        // 出了上面的for循环 就选出了构成最小生成树的边
        System.out.println("最小生成树为");
        for(int i = 0; i < index; i++) {
            System.out.println(res[i]);
        }
    }
    public static void main(String[] args) {
        char[] vertexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //克鲁斯卡尔算法的邻接矩阵
        int matrix[][] = {
                        /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        Kruskal kruskal = new Kruskal(vertexs, matrix);
//        kruskal.print();
/*        System.out.println(Arrays.toString(kruskal.getEdges()));
        EData[] edges = kruskal.getEdges();
        kruskal.sortEdges(edges);
        System.out.println(Arrays.toString(edges));*/
        kruskal.kruskal();
    }
}
// 创建一个类EData ，它的对象实例就表示一条边
class EData {
    char start; // 边的一个点
    char end; // 边的另外一个点
    int weight; // 边的权值
    // 构造器
    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    // 重写toString, 便于输出边信息
    @Override
    public String toString() {
        return "EData [<" + start + ", " + end + ">= " + weight + "]";
    }


}