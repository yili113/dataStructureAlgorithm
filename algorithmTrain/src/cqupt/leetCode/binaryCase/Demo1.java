package cqupt.leetCode.binaryCase;

/**
 * @author yiLi
 * @create 2020-06-21 10:03
 * 搜索一个数
 *
 * 对于while(left<=right)的形式 是搜索的[left,right]这个闭区间,也就是说左右两侧边界都会搜索到
 * 出循环之后肯定是这个区间的所有元素都搜索完了
 * 对应的要用到 right=mid-1  left=mid+1  因为是闭区间,mid位置上不满足的话肯定从旁边的元素搜索,因为mid已经搜索过了
 */
public class Demo1 {
    public static int findTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
//        while (left + 1 < right) {// 这种情况出来之后是 left在right左侧
        while (left <= right) {// 这种情况出来之后是 left在right右侧
            int mid = left + (right - left) / 2;
            if (nums[mid] > target)// target在mid左侧
                right = mid - 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] == target)
                return mid;
        }
//        if (nums[left] == target)
////            return left;
////        if (nums[right] == target)
////            return right;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 6, 8, 8, 8, 9, 9, 9, 9, 9};
        int target = 9;
        System.out.println(findTargetLeft(nums, target));
        System.out.println(findTargetLeft1(nums, target));
        System.out.println(findTargetRight(nums, target));
        System.out.println(findTargetRight1(nums, target));

    }

    // 搜索目标元素的左边界
    public static int findTargetLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                right = mid;
            else if (nums[mid] > target)
                right = mid;
            else if (nums[mid] < target)
                left = mid + 1;
        }
        // left的含义是:小于target的元素有几个
        if (left >= nums.length)// 这种情况就说明target比数组所有元素都大
            return -1;
        return nums[left] == target ? left : -1;
    }

    // 搜索目标元素的右边界
    public static int findTargetRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
            else if (nums[mid] < target)
                left = mid + 1;
        }
//        return left - 1;
        if (left == 0)
            return -1;
        // 为什么用left-1 因为最后出循环时候是left=right 而右侧是开区间的
        return nums[left - 1] == target ? left - 1 : -1;
    }
    // 搜索左侧边界  闭区间写法
    public static int findTargetLeft1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                right = mid - 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else if (nums[mid] < target)
                left = mid + 1;
        }
        // 判断越界问题
        // 下面判断越界问题
        // 1.对于寻找左侧边界,如果target大于数组所有的元素,left就会一直向右,导致越界
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }
    public static int findTargetRight1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
            else if (nums[mid] < target)
                left = mid +1;
        }
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

}