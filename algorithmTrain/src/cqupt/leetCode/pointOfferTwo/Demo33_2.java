package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-28 10:44
 * 根据后序遍历数组生成树
 * 前提是此数组是后序数组,不用判断是与否
 */
public class Demo33_2 {
    public TreeNode posArrayToBST(int[] posArr) {
        if (posArr == null)
            return null;
        return helper(posArr, 0, posArr.length - 1);
    }

    private TreeNode helper(int[] posArr, int l, int r) {
        if (l >= r)
            return null;
        TreeNode head = new TreeNode(posArr[r]);
        int p = l;
        while (posArr[p] < posArr[r])
            p ++;
        head.left = helper(posArr, l,p - 1);
        head.right = helper(posArr, p, r - 1);
        return head;
    }
}
