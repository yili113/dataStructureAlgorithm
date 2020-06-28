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
    // 未成功  此种方法在helper2得到改进
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

    private static boolean helper2(int[] postorder, int l, int r) {
        if (l >= r)
            return true;
        int less = -1;
        int more = r;
        for (int i = l; i < r; i++) {// 这个地方会把l--r左闭右开区间上元素都遍历完,一直在更新less
            if (postorder[i] < postorder[r])
                less = i;
            else
                more = more == r ? i : more;
        }
        if (less == -1 || more == r)// 解决了左右子树只有一种的情况,less=-1表明只有比根结点大的结点,more=r只有小的
            return helper2(postorder,l, r - 1);
        if (less != more - 1)// 像 1,6,3,2,5  less指向3  more指向6   返回false
            return false;
        return helper2(postorder,l,less) && helper2(postorder,more,r - 1);
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
