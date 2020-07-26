package cqupt.leetCode.pointOfferThree;

/**
 * @author yiLi
 * @create 2020-07-25 14:01
 * 二叉搜索树的后续遍历
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 输入: [1,3,2,6,5]
 * 输出: true
 */
public class Demo33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return false;
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int left, int right) {
        if (left >= right)
            return true;
        int root = postorder[right];
        int mid = 0;// 右子树开头
        int index = 0;
        while (postorder[index] < root)
            index ++;
        mid = index;
        while (postorder[index] > root)
            index ++;
        return index == right && helper(postorder, left, mid - 1) && helper(postorder, mid, right - 1);
    }
}
