package cqupt.leetCode.pointOfferTwo;


import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-23 9:45
 */
public class Demo07 {
    // 前序遍历 preorder = [3,9,20,15,7]
    // 中序遍历 inorder = [9,3,15,20,7]
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        int headVal = preorder[0];
        int index = 0;
        int n = inorder.length;
        for (int i = 0; i < n; i++) {
            if (inorder[i] == headVal) {
                index = i;
                break;
            }
        }
        TreeNode head = new TreeNode(headVal);
        head.left = buildTree(Arrays.copyOfRange(preorder, 1, index + 1),
                Arrays.copyOfRange(inorder, 0, index));
        head.right = buildTree(Arrays.copyOfRange(preorder,index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return head;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
