package cqupt.leetCode;



/**
 * @author Liyi
 * @create 2020-03-03 13:45
 */
public class T100_101 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode q = new TreeNode(1);
        p.left = node2;
        p.right = node2;
        q.left = node2;
        q.right = node3;
//        System.out.println(isSameTree1(p, q));
        System.out.println(isSymmetric(p));
    }

    /**
     * 错误的
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p.val != q.val)
            return false;
        else {
            if (p.left != null && q.left != null) {
                boolean flag = isSameTree(p.left, q.left);
                if (!flag)
                    return false;
            } else {
                return false;
            }
            if (p.right != null && q.right != null) {
                boolean flag = isSameTree(p.right, q.right);
                if (!flag)
                    return false;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两树是否相等
     * @param p
     * @param q
     * @return
     */
    public static boolean isSameTree1(TreeNode p, TreeNode q) {

        if(p == null && q == null) return true;
        if((p != null && q == null) || (p == null && q != null)) return false;
        return p.val == q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);

    }

    /**
     * 判断树是否对称
     * @param root
     * @return
     */
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (left == null || right == null)
            return false;
        return left.val == right.val && isMirror(left.left, right. right) &&  isMirror(left.right, right.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
