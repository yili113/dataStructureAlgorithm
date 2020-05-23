package cqupt.leetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yiLi
 * @create 2020-05-23 9:49
 */
public class IsCBT {


    public boolean isCBT(TreeNode root) {
        if (root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode l = null;
        TreeNode r = null;
        while (!queue.isEmpty()) {
            root = queue.poll();
            l = root.left;
            r = root.right;
            if (l == null && r != null )
                return false;
        }
        return false;
    }
    public boolean hasK(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        while (k > 0) {
            list.add(k);
            k /= 2;
        }
        for (int i = list.size() - 1; i >= 0 ; i--) {
            if (root == null)
                return false;
            if (i == 0)
                return true;
            if (list.get(i - 1) == 2 * list.get(i))
                root = root.left;
            else
                root = root.right;
        }
        return false;
    }
    public int numNode(TreeNode root) {
        if (root == null)
            return 0;
        TreeNode cur = root;
        int height = 0;
        while (cur != null) {
            height ++;
            cur = cur.left;
        }
        int low = (int) Math.pow(2, height - 1);
        int high = (int) Math.pow(2, height);
        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            if (hasK(root, mid))
                low = mid;
            else
                high = mid;
        }
        return low;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 2));
    }
}
