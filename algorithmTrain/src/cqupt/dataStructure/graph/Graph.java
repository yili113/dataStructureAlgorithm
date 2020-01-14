package cqupt.dataStructure.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-01-14 15:05
 * 图的创建与遍历
 */
public class Graph {
    public static void main(String[] args) {
        int n = 5;// 测试8个顶点的图的创建
        String Vertexs[] = {"A", "B", "C", "D", "E"};
        Graph graph = new Graph(n);
        // 循环地添加顶点
        for(String vertex : Vertexs) {
            graph.insertVertex(vertex);
        }
        // 添加边
        // A-B A-C B-C B-D B-E
        graph.insertEdge(0, 1, 1);
        // 显示图
        graph.showGraph();
    }

    private ArrayList<String> vertexList;// 存储顶点的集合
    private int[][] edges;// 存放图对应的邻接矩阵
    private int numOfEdges;// 表示边的数目
    private boolean[] isVisited;// 表示该顶点是否被访问过

    // 构造器 顶点个数
    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>(n);
        numOfEdges = 0;
    }

    /**
     * 重载dfs方法
     */
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        // 遍历所有的结点 进行dfs
        for (int i = 0; i < getNumOfVertexs(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
    }
    /**
     * 深度优先遍历算法
     * @param isVisited 每个结点是否被遍历过的标识
     * @param i 从i的这个结点开始
     */
    public void dfs(boolean[] isVisited, int i ) {
        // 1.先输出当前结点
        System.out.println(getValueByIndex(i));
        // 2.将结点设置为已访问
        isVisited[i] = true;
        // 3.查找i结点的第一个邻接结点w
        int w = getFirstNeighbor(i);
        while (w != -1) {
            if (!isVisited[w]) {// 如果w没有被访问过
                dfs(isVisited, w);
            }
            // 如果w已经被访问过了
            w = getNextNeighbor(i, w);
        }

    }

    /**
     * 得到当前结点的第一个邻接结点的下标
     * @param index
     * @return 如果存在就返回对应的下标 否则返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据结点i下标得到对应的数据
     * @param i
     * @return
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }
    /**
     * 得到顶点个数
     * @return
     */
    public int getNumOfVertexs() {
        return vertexList.size();
    }

    /**
     * 得到边的个数
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }
    /**
     * 根据前一邻接结点的下标来获取下一邻接结点
     * @param v1
     * @param v2
     * @return
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 显示图
     */
    private void showGraph() {
        for (int[] link : edges) {
            System.out.println(Arrays.toString(link));
        }
    }

    /**
     * 添加边
     * @param v1
     * @param v2
     * @param weight 两个顶点间的权重  值
     */
    private void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;// 目前是无向图 相互的权重
        numOfEdges ++;
    }

    /**
     * 添加顶点
     * @param vertex
     */
    private void insertVertex(String vertex) {
        vertexList.add(vertex);
    }


}
