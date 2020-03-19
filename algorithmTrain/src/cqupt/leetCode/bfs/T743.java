package cqupt.leetCode.bfs;

import java.util.*;

/**
 * @author Liyi
 * @create 2020-03-19 8:48
 * 网络延迟时间---最短路径加权和---Dijkstra
 * 我们从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？
 * 如果不能使所有节点收到信号，返回 -1。
 */
public class T743 {
    /**
     *
     * @param times times.length是边数
     * @param N
     * @param K
     * @return
     */
    public static int networkDelayTime(int[][] times, int N, int K) {
        int res = 0;
        HashSet visited = new HashSet<Integer>();// 记录遍历过的点
        HashMap<Integer, ArrayList<List<Integer>>> graph = new HashMap();
        for (int[] time : times) {
            if (!graph.containsKey(time[0])) {
                ArrayList<List<Integer>> curLists = new ArrayList<>();
                ArrayList<Integer> curList = new ArrayList<>();
                curList.add(time[1]);
                curList.add(time[2]);
                curLists.add(curList);
                graph.put(time[0], curLists);
            }else {
                ArrayList<List<Integer>> curLists = graph.get(time[0]);
                ArrayList<Integer> curList = new ArrayList<>();
                curList.add(time[1]);
                curList.add(time[2]);
                curLists.add(curList);
            }
        }
        Com comHelper = new Com();
        PriorityQueue pq = new PriorityQueue<List<Integer>>(comHelper);
        ArrayList<Integer> headList = new ArrayList<>();
        headList.add(K);// 第一个结点的结合 结点下标和结点的权重
        headList.add(0);
        pq.add(headList);
        while (!pq.isEmpty()) {
            ArrayList cur = (ArrayList) pq.poll();
            if (visited.contains(cur.get(0))) {// 当前这个结点已经被访问过
                continue;
            }
            visited.add(cur.get(0));// 将当前结点标记为已访问
            res = Math.max(res, (Integer) cur.get(1));
            if (graph.containsKey(cur.get(0))) {
                for (List<Integer> list : graph.get(cur.get(0))) {// 看当前结点的邻接结点
                    if (visited.contains(list.get(0)))// 当前这个邻接结点被访问过
                        continue;
                    // 当前这个邻接结点没有被访问过
                    ArrayList<Integer> newList = new ArrayList<>();
                    newList.add(list.get(0));
                    int newSum = list.get(1) + (Integer) cur.get(1);
                    newList.add(newSum);
                    pq.add(newList);
                }
            }
        }
        return visited.size() == N ? res : -1;
    }

    public static void main(String[] args) {
        // times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime(times, 4, 2));
    }
}
class Com implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
        return o1.get(1) - o2.get(1);
    }// 实现最小堆 优先队列的头部为小元素
}
