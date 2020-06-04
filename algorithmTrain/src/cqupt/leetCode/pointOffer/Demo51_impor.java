package cqupt.leetCode.pointOffer;

/**
 * @author yiLi
 * @create 2020-06-04 16:58
 * 数组中的逆序对
 * 归并排序模板
 */
public class Demo51_impor {
    private int COUNT;
    public int[] reversePairs(int[] nums) {
//        if (nums == null || nums.length == 0)
//            return 0;
        COUNT = 0;
        divide(nums, 0, nums.length - 1);
        return nums;
    }

    private void divide(int[] nums, int l, int r) {
        if (l == r)
            return;
        int mid = l + (r - l) / 2;
        divide(nums, l, mid);
        divide(nums,mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int i = l;
        int j = mid + 1;
        int index = 0;
        int[] temp = new int[r - l + 1];
        while (i <= mid && j <= r) {
            if (nums[i] > nums[j]) {// 左侧比右侧大,这种情况下出现逆序
                temp[index ++] = nums[j ++];
                COUNT += mid - i + 1;// 统计逆序对数量
                // 如果左侧第i个元素比右侧第j个元素大,就肯定会有左侧i+1到mid这些元素都比右侧第j个元素大
                // 因为归并排序 左侧或者右侧只要大于1的数量就肯定是排序好的
            }else {
                temp[index ++] = nums[i ++];
            }
        }
        while (i <= mid) {// 此时左边的还没添加到temp中结束,但是剩下的都是有序的,直接添加即可
            temp[index ++] = nums[i ++];
        }
        while (j <= r)
            temp[index ++] = nums[j ++];
        // 将temp数组中元素拷贝到原数组
        index = 0;
        for (int k = l; k <= r; k++) {
            nums[k] = temp[index ++];
        }
    }
}
