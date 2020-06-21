package cqupt.leetCode.monotonousQueue;

import java.util.ArrayList;

/**
 * @author yiLi
 * @create 2020-06-17 11:05
 */
public class Demo59_1 {
    public static ArrayList maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0)
//            return new int[]{};
            return null;
        ArrayList<Integer> res = new ArrayList<>();
        MonotonousQueue queue = new MonotonousQueue();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1)
                queue.push(nums[i]);
            else {
                queue.push(nums[i]);
                res.add(queue.getMax());
                queue.poll(nums[i - k + 1]);
            }
        }
        int[] resArr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i] = res.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
//        nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
        int[] nums =  {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
//        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
        System.out.println(maxSlidingWindow(nums,k));
    }
}
