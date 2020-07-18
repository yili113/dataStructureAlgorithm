package cqupt.leetCode.pointOfferThree;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-07-18 12:39
 * 重建二叉树
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Demo7 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;
        int first = preorder[0];// 前序遍历的第一个元素就是根
        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == first) {
                index = i;
                break;
            }
        }
        TreeNode head = new TreeNode(first);
        head.left = buildTree(Arrays.copyOfRange(preorder,1,index + 1),
                Arrays.copyOfRange(inorder,0, index));
        head.right = buildTree(Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length));
        return head;
    }
}
