package cqupt.leetCode.tree;

/**
 * @author Liyi
 * @create 2020-03-19 17:21
 * 二叉树的最近公共祖先---套用分治模板
 * 1.写一个helper函数
 * 2.写一个结果类 把需要的属性放在类中
 * 具体：
 * 1.判断当前结点
 * 2.判断左右结点
 */
public class T236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q).lcd;
    }

    /**
     *
     * @param root
     * @param p
     * @param q
     * @return 返回一个结果集
     */
    private ResType helper(TreeNode root, TreeNode p, TreeNode q) {
        ResType res = new ResType();
        // 1.判断当前结点
        if (root == null) {
            return res;
        }
        // 2.看看左右子树
        ResType left = helper(root.left, p, q);
        ResType right = helper(root.right, p, q);
        // 如果从left或right中找到了lcd,那么就赋给res
        if (left.lcd != null) {
            res.lcd = left.lcd;
            return res;
        }
        if (right.lcd != null) {
            res.lcd = right.lcd;
            return res;
        }
        // 如果到了这个地方说明 root的左右子树中都没找到lcd
        // 此时就需要判断 p和q是否有
        res.hasP = root == p || left.hasP || right.hasP;
        res.hasQ = root == q || right.hasQ || left.hasQ;
        // 判断p和q是否有了
        if (res.hasP && res.hasQ) {// 说明root是最近的公共祖先
            res.lcd = root;
        }
        return res;
    }
}
class ResType {
    boolean hasP;// 是否包含p结点
    boolean hasQ;
    TreeNode lcd;// 表示最近的公共祖先
}
