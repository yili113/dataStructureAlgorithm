package cqupt.algorithm.graphAlgorithm;

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
            for (int j = 0; j < vertexs.length; j++) {
                if (matrix[i][j] != INF)
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
        kruskal.print();
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