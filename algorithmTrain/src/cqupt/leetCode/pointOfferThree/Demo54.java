package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-08-03 10:32
 * 二叉搜索树中第k大结点
 * 采用右中左 遍历顺序找第k大元素
 */
public class Demo54 {

    private int COUNT = 0;
    private int RES = -1;

    public int kthLargest(TreeNode root, int k) {
        if (root == null)
            return 0;
        helper(root, k);
        return RES;

    }

    // helper函数要是定义成带返回值的就比较难受
    // 用一个成员变量来记录最终返回结点的值,避免递归中返回值操作
    private void helper(TreeNode root, int k) {
        if (root.right != null)
            kthLargest(root.right, k);
        COUNT ++;
        if (COUNT == k) {
            RES = root.val;
        }
        if (root.left != null)
            kthLargest(root.left, k);
    }
}
