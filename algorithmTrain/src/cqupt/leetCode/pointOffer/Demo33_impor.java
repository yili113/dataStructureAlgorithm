package cqupt.leetCode.pointOffer;

import java.util.Arrays;

/**
 * @author yiLi
 * @create 2020-06-01 14:58
 */
public class Demo33_impor {
    public boolean verifyPostorder1(int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return false;
        return helper1(postorder);
    }

    private boolean helper1(int[] postorder) {
        if (postorder == null || postorder.length == 1)
            return true;
        int root = postorder[postorder.length - 1];
        int mid = -1;
        for (int i = 0; i < postorder.length - 1; i++) {
            if (postorder[i] > root) {
                mid = i;
                break;
            }
        }
        if (mid == -1)
            return true;
        for (int i = mid; i < postorder.length - 1; i++) {
            if (postorder[i] < root)
                return false;
        }
        return helper1(Arrays.copyOfRange(postorder, 0, mid))
                && helper1(Arrays.copyOfRange(postorder, mid, postorder.length - 1));
    }

    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }

    private boolean helper(int[] postorder, int l, int r) {
        if (l >= r)
            return true;
        int p = l;
        while (postorder[p] < postorder[r])
            p ++;
        int m = p;// m就是右子树的第一个位置
        while (postorder[p] > postorder[r])
            p ++;
        // p==r 为true说明从 m到r-1 的元素都比 r 的大
        return p == r && helper(postorder, l, m -1) && helper(postorder, m, r - 1);
    }
}
