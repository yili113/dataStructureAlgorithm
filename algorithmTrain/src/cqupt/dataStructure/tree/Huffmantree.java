package cqupt.dataStructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yiLi
 * @create 2020-01-07 20:24
 */
public class Huffmantree {
    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node huffmanTreeRoot = createHuffmanTree(arr);
        preOrder(huffmanTreeRoot);
    }
    public static Node createHuffmanTree(int[] arr) {
        // 将数组中的元素包装成结点 方便使用结点类的比较方法
        List<Node> nodes = new ArrayList<>();
        for(int ele : arr) {
            nodes.add(new Node(ele));
        }


        // 开始处理
        // 当列表中只剩一个结点时结束 这个最后剩下的结点就是最终哈夫曼树的根结点
        while (nodes.size() > 1) {
            // 1.排序从小到大
            Collections.sort(nodes);
            // 2.取出当前列表中权值最小的两个结点 每个结点都可以看做是一个二叉树
            Node leftNode = nodes.get(0);
            Node rightNode = nodes.get(1);
            // 3.构建一个新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            // 拼接上
            parent.left = leftNode;
            parent.right = rightNode;
            // 4.从列表中删除刚才用于拼接新二叉树的两个结点
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            // 5.将父结点（新拼接的二叉树的根结点）放进列表中
            nodes.add(parent);
        }
        // 返回最终哈夫曼树的根结点
        return nodes.get(0);
    }

    /**
     *
     * @param root
     */
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        }else {
            System.out.println("空树");
        }
    }
}

/**
 * 结点类
 * 增添排序方法
 */
class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        // 表示从小到大排序
        // 要是从大到小加个-号即可
        return this.value - o.value;
    }

    /**
     * 前序遍历
     */
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

}
