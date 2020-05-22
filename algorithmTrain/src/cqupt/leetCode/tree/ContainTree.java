package cqupt.leetCode.tree;

/**
 * @author yiLi
 * @create 2020-05-21 22:02
 */
public class ContainTree {
    public static boolean contains(TreeNode t1, TreeNode t2) {
        if (t2 == null)// t2已经遍历完了
            return false;
        if (t1 == null)// t1已经遍历完了,但是t2还没遍历完
            return false;
        // 如果t1 t2都还剩  就去比较两个结点是否相等
        // 不然就t1的子结点开始去匹配t2
        return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }

    private static boolean check(TreeNode t1, TreeNode t2) {
        if (t2 == null)
            return true;
        if (t1 == null || t1.val != t2.val)
            return false;
        // 到这一步就说明 t1和t2是匹配的
        // 接下来去匹配二者对应的子结点
        return check(t1.left, t2.left) && check(t1.right, t2.right);
    }
}
