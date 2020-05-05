package cqupt.taluotaluotu;

/**
 * @author Liyi
 * @create 2020-05-03 9:26
 * 找第k大的元素
 */
public class QuickSelect {

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        int k  = 2;
        quickSelect(nums, k, 0, nums.length - 1);
        System.out.println(nums[k - 1]);
    }

    private static void quickSelect(int[] nums, int k, int start, int end) {
        if (start >= end)
            return;
        int l = start + 1;
        int r = end;
        int pivot = nums[start];// 记住这个pivot选的是值而不是下标,因为后续比较的是值
        while (l <= r) {// l<=r为的是让出循环时候r指向在l左边
            if (nums[l] > pivot) {
                l ++;
                continue;
            }
            if (nums[r] <= pivot) {
                r --;
                continue;
            }
            swap(nums, l, r);
        }
        swap(nums, start, r);
        // 此时pivot左边的比其大,右边的比其小
        // r指向的就是pivot
        if (r - start + 1 == k) {// r-start表示的是下标,+1才表示第几大
            return;
        }
        if (r - start + 1 > k) {// r左边的元素个数大于k,就要从左侧接着找
            quickSelect(nums, k, start, r - 1);
        }else {
            quickSelect(nums, k - (l - start), l, end);// 从右侧找第k - (l - start)大的,l - start  == r - start + 1
        }
    }

    private static void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
