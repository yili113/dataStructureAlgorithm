package cqupt.leetCode.pointOfferThree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yiLi
 * @create 2020-08-18 9:03
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || input.length == 0)
            return res;
        helper(input, 0, input.length - 1, k);
        for(int i = 0; i < k; i++)
            res.add(input[i]);
        return res;
    }
    public void helper(int[] arr, int left, int right, int k) {
        if(left >= right)
            return;
        int l = left + 1;
        int r = right;
        int pivot = arr[left];
        while(l <= r) {
            if(arr[l] <= pivot) {
                l ++;
                continue;
            }
            if(arr[r] > pivot) {
                r --;
                continue;
            }
            swap(arr, l, r);
        }
        swap(arr, left, r);
        if((r - left + 1) == k) {

        }
        else if ((r - left + 1) > k) {
            helper(arr, left, r - 1, k);
        }else if((r - left + 1) < k) {
            helper(arr, l, right, k - (l - left));
        }
    }
    public void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length == 0)
            return "";
        String[] strs = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            strs[i] = numbers[i] + "";
        }
//        Arrays.sort(strs, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return (o1 + o2).compareTo(o2 + o1);
//            }
//        });
        return "";
    }
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return true;
        return helper(sequence, 0, sequence.length - 1);
    }
    public boolean helper(int[] sequence, int left, int right) {
        if (left >= right)
            return true;
        int m = -1;
        int root = sequence[right];
        int index = left;
        while(sequence[index] < root) {
            index ++;
        }
        m = index;
        int p = -1;
        while(sequence[index] > root) {
            index ++;
        }
        p = index;
        return p == right && helper(sequence, left, m - 1) && helper(sequence, m, right - 1);
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        int[] arr = {2,3,4,2,6,2,5,1};
//        ArrayList<Integer> res = solution.GetLeastNumbers_Solution(arr, 2);
//        boolean res = solution.VerifySquenceOfBST(arr);
//        int[] res = solution.singleNumbers(arr);
        ArrayList<Integer> res = solution.maxInWindows(arr, 3);
        System.out.println(res);
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        in.readLine();
    }
    public int[] singleNumbers(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[]{};
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int zerosCount = 0;
        for(int num : nums) {
            if(num == 0)
                zerosCount ++;
            sum ^= num;
            // !!!卧槽
            min = Math.max(max, num);
            max = Math.min(min, num);
        }
        if(zerosCount == 1){
            // num1[0] = 0;
            // num2[0] = sum;
            return new int[]{0, sum};
        }
        int l = min;
        int r = max;
        while(l <= r) {
            int mid = l + (r - l) / 2;
            int leftSum = 0;
            int rightSum = 0;
            for(int num : nums) {
                if(num <= mid)
                    leftSum ^= num;
                else
                    rightSum ^= num;
            }
            if(leftSum != 0 && rightSum != 0) {
                // num1[0] = leftSum;
                // num2[0] = rightSum;
                return new int[]{leftSum, rightSum};
            }else if(leftSum != 0) {
                r = mid - 1;
            }else if(rightSum != 0)
                l = mid + 1;
        }
        return null;
    }
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(num == null || num.length == 0 || size > num.length)
            return res;
        int l = 0;
        int r = 0;// 左闭右开
        while(r < num.length) {
            r ++;
            while(r - l == size) {
                res.add(getMax(num, l, r - 1));
                l ++;
            }
        }
        return res;
    }
    public int getMax(int[] nums, int l, int r) {
        int max = Integer.MIN_VALUE;
        for(int i = l; i <= r; i ++)
            max = Math.max(nums[i], max);
        return max;
    }
}