package cqupt.leetCode.pointOffer;

import java.util.HashMap;

/**
 * @author yiLi
 * @create 2020-06-05 8:30
 */
public class Demo53_1_todo {
    // todo
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
