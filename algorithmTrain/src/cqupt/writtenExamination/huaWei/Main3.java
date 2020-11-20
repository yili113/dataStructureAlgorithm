package cqupt.writtenExamination.huaWei;

import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

/**
 * @author yiLi
 * @create 2020-09-06 19:01
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        Node[][] grid = new Node[n][m];
        Node node = null;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                node = new Node();
                node.pD = sc.nextDouble();
                node.pR = sc.nextDouble();
                node.pS = sc.nextDouble();
                grid[i][j] = node;
            }
        }
        sc.close();
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        double res = 0;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] curPoint = queue.poll();
            if (visited[curPoint[0]][curPoint[1]] || curPoint[0] < 0 || curPoint[0] >= n ||
                    curPoint[1] < 0 || curPoint[1] >= m)
                continue;
            if (curPoint[0] == n - 1 && curPoint[1] == m - 1)
                break;
            visited[curPoint[0]][curPoint[1]] = true;
            Node curNode = grid[curPoint[0]][curPoint[1]];
            if (curNode.pD != 0) {// 可以向下走
                res += 1 / curNode.pD;
                queue.add(new int[]{curPoint[0] + 1, curPoint[1]});
            }else if (curNode.pR != 0) {// 可以向右走
                res += 1 / curNode.pR;
                queue.add(new int[]{curPoint[0], curPoint[1] + 1});
            }else if (curNode.pS != 0)
                res += 1 / curNode.pS;
        }
        System.out.println(res);
    }
}
class Node {
    double pD;
    double pR;
    double pS;

    @Override
    public String toString() {
        return "Node{" +
                "pD=" + pD +
                ", pR=" + pR +
                ", pS=" + pS +
                '}';
    }
}