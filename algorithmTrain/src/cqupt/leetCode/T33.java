package cqupt.leetCode;

/**
 * @author Liyi
 * @create 2020-03-04 17:15
 * 搜索旋转排序数组
 */
public class T33 {



    /**
     * 常规二分查找
     * @param arr
     * @param target
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        /**
         * while循环之后 left和right是相邻的 left和right不能指向同一个元素
         * 假如说while(left < right) 要是 left=2 right=3  求出来的mid=2
         * 就会陷入一个 left一直等于mid的一个循环
         */
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (target == arr[mid])
                return mid;
            else if (target < arr[mid])
                right = mid;
            else left = mid;
        }
        if (arr[left] == target)// 因为while最后肯定会剩两个元素 就分别判断这两个元素是否等于target
            return left;
        if (arr[right] == target)
            return right;
        return -1;// 两个元素都不等就返回没找到
    }

    /**
     * 搜索旋转排序数组 --- 也是利用二分查找的方法
     * 本身就是一个有序的数组，只不过从中间某处后边的挪到了前面
     * 也就是说 在分割线左侧的要比右侧的元素大
     * 并且 分别看两侧的元素都是有序的
     *
     * 先求出nums[mid]  mid的位置只有两种情况 要么在分割线左侧要么在分割线右侧
     * 1.mid在分割线左侧 nums[left] < nums[mid]
     * 1.1 target >= nums[left] && target <= nums[mid]  target在left和mid中间
     * 1.2 target在mid右侧
     *
     * 2.mid在分割线右侧 nums[mid] < nums[right]
     * 2.1 nums[mid] <= target && target <= nums[right] target在mid和right中间
     * 2.2 target在mid左侧
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;// 这样取中间值防止overflow  比(left+right)/2好
            if (target == nums[mid])
                return mid;
            // 1.mid在分割线左侧
            if (nums[left] < nums[mid]) {// 说明mid在分割线左侧，在右侧是不可能的，分割线右侧的所有元素都比nums[left]小
                // 1.1 target在left和mid中间
                if (target >= nums[left] && target <= nums[mid]) {
                    right = mid;
                }else {// 1.2 target在mid右侧
                    left = mid;
                }
            }else if (nums[mid] < nums[right]) {// 2.mid在分割线右侧 只有分割线右边的元素才比nums[right]小
                if (nums[mid] <= target && target <= nums[right]) {// 2.1 target在mid和right中间
                    left = mid;
                }else {// 2.2 target在mid左侧
                    right = mid;
                }
            }
        }
        // 出了while循环就剩两个元素
        if (target == nums[left])
            return left;
        if (target == nums[right])
            return right;
        return -1;// 如果target不在最后的两个元素中就没找到
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 3;
//        System.out.println(binarySearch(arr, target));
        System.out.println(search(arr, target));
    }
}
