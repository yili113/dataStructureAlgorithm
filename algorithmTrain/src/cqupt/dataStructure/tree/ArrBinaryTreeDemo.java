package cqupt.dataStructure.tree;

/**
 * @author yiLi
 * @create 2020-01-07 9:08
 * 顺序存储二叉树
 * 也就是说用数组存储二叉树
 * 父节点下标为index 那么其左子结点的下标为index*2+1 右子结点的下标为index*2+2
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.arrPreOrder();
    }
}
class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 重载下面的方法 显得代码干净
     */
    public void arrPreOrder() {
        arrPreOrder(0);
    }

    /**
     * 顺序存储完全二叉树
     * @param index 数组的下标 从0开始
     */
    public void arrPreOrder(int index) {
        if (arr == null || arr.length ==0) {
            System.out.println("数组为空 不能进行遍历");
        }
        System.out.println(arr[index]);// 先打印当前数组元素 相当于树的父节点
        // 向左递归遍历左子树  并且左侧下标没有越界
        if (2 * index + 1 < arr.length) {
            arrPreOrder(2 * index + 1);
        }
        if (2 * index + 2 < arr.length) {
            arrPreOrder(2 * index + 2);
        }
    }
}
