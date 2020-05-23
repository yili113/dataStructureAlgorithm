package cqupt.leetCode.tree;

/**
 * @author yiLi
 * @create 2020-05-22 16:07
 */
public class IsPostArr {


    public static boolean isPostArr(int[] arr) {
        if (arr == null || arr.length == 0)
            return false;
        return isPost(arr, 0, arr.length - 1);
    }

    private static boolean isPost(int[] arr, int start, int end) {
        if (start == end)
            return true;
        int l = start;
        int r = end;
        for (int i = l; i < r; i++) {// 最后到end的前一位
            if (arr[i] >= arr[end])// 选右子树
                r = r == end ? i : r;// 保证右子树序列指向最左边那个
            else // 选左子树
                l = i;
        }
        if (l == -1 || r == end)
            return isPost(arr, start, end - 1);
        if (l != r - 1)
            return false;
        return isPost(arr, start, l) && isPost(arr, r, end - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPostArr(new int[]{2, 1, 3, 6, 5, 7, 4}));
    }
}
