package cqupt.leetCode.tree;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-05-23 11:31
 * 重建平衡二叉搜索树
 */
public class GenerateTree {
    public TreeNode generateTree(int[] arr) {
        TreeNode root = null;
        if (arr == null || arr.length == 0)
            return root;
//        return generateInorder(arr, 0, arr.length - 1);
        Arrays.sort(arr);
        return generatePreorder(arr, 0, arr.length - 1);
    }

    private TreeNode generatePreorder(int[] arr, int left, int right) {
        if (left > right)
            return null;
        TreeNode head = new TreeNode(arr[left]);
        int l = left + 1;
        int mid = l + (right - l) / 2;
        head.left = generatePreorder(arr, l, mid);
        head.right = generatePreorder(arr, mid + 1, right);
        return head;
    }

    private TreeNode generateInorder(int[] arr, int left, int right) {
        if (left > right)
            return null;
        int mid = left + (right - left) / 2;
        TreeNode head = new TreeNode(arr[mid]);
        head.left = generateInorder(arr, left, mid - 1);
        head.right = generateInorder(arr, mid + 1, right);
        return head;
    }
}
