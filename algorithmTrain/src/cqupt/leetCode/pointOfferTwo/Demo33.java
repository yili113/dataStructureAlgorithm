package cqupt.leetCode.pointOfferTwo;

/**
 * @author yiLi
 * @create 2020-06-27 11:02
 */
public class Demo33 {
    public static boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 0)
            return false;
        return helper(postorder, 0, postorder.length - 1);
    }
    // 未成功
    private static boolean helper(int[] postorder, int l, int r) {
        if (l >= r)
            return true;
        int rootVal = postorder[r];
        // 找到左右子树分界值
        int index = l;
        for (int i = l; i < r; i++) {
            if (postorder[i] > rootVal) {
                index = i;
                break;
            }
        }
        if (index == l && postorder[index] < postorder[r])
            index ++;
        for (int i = index; i < r; i++) {
            if (postorder[i] < rootVal)
                return false;
        }
        return helper(postorder, l, index - 1) && helper(postorder, index, r - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(verifyPostorder(nums));
    }

    private static boolean helper1(int[] postorder, int l, int r) {
        if (l >= r)
            return true;
        int p = l;
        while (postorder[p] < postorder[r])
            p ++;
        int m = p;// 右侧的起始点
        while (postorder[p] > postorder[r])
            p ++;
        return p == r && helper1(postorder, l, m - 1) && helper1(postorder, m, r - 1);
    }
}
