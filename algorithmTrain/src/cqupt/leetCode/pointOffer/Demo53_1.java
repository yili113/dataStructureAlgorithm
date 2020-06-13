package cqupt.leetCode.pointOffer;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-06-05 8:30
 */
public class Demo53_1 {
    // 二分法
    public int search1(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1 && nums[0] == target)
            return 1;
        int count = 0;
        int l = 0;
        int r = nums.length - 1;
        while (l + 1 < r) {
            int pivot = (r - l) / 2 + l;// 这行代码要写在while循环内部
            if (nums[pivot] < target)
                l = pivot;
            else if (nums[pivot] > target)
                r = pivot;
            else {
                count += 1;
                if (nums[l] != target)
                    l = pivot +1;
                else if (nums[r] != target)
                    r = pivot - 1;
            }
        }
        if (l == r && nums[l] == target)
            count += 1;
        else {
            if (nums[l] == target)
                count += 1;
            if (nums[r] == target)
                count += 1;
        }
        return count;
    }
    // 排序好的数组 只需要找到target重复数字的左右边界即可
    public int search2(int[] nums, int target) {
        // 找右边界
        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {// 这种出口条件出来之后  i在j右边一个位置
            int mid = (j - i) / 2 + i;
            if (nums[mid] <= target)
                i = mid + 1;
            else j = mid - 1;
        }
        int right = i;
        if (j >= 0 && nums[j] != target)
            return 0;
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int mid = (j - i) / 2 + i;
            if (nums[mid] < target)
                i = mid + 1;
            else j = mid - 1;
        }
        int left = j;
        return right - left - 1;// 找到的left是最左边那个目标数的左边一个位置   right是最右边目标数的右边一个位置
    }

        // 哈希表进行记录
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i]) + 1);
        }
        for (Integer num : map.keySet()) {
            Integer values = map.get(target);
            if (values == null)
                return 0;
            return values;
        }
        return 0;
    }

    public static void main(String[] args) {
        // nums = [5,7,7,8,8,10], target = 8
        System.out.println(search(new int[]{5,7,7,8,8,10}, 8));
    }
}
