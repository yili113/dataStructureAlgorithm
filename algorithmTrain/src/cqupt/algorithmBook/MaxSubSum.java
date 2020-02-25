package cqupt.algorithmBook;

/**
 * @author yiLi
 * @create 2019-12-19 19:22
 */
public class MaxSubSum {
    public static void main(String[] args) {
        int arr[] = {-2, 11, -4, 13, -5, -2};
//        int result = maxSubSum3(arr);
        int x = -4;
//        int result = binarySearch(arr, x);
        long gcd = gcd(50, 15);
        System.out.println(gcd);
    }

    private static int binarySearch(int[] arr, int x) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < x) {
                low = mid + 1;
            }else if(arr[mid] > x) {
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static int maxSubSum3(int[] arr) {
        int maxSum = 0;
        int thisSum = 0;
        for (int i = 0; i < arr.length; i++) {
            thisSum += arr[i];
            if (maxSum < thisSum) {
                maxSum = thisSum;
            }else if (thisSum < 0){
                thisSum = 0;
            }
        }
        return maxSum;
    }

    public static long gcd(int m, int n) {
        while(n != 0) {
            int rem = m % n;
            m = n;
            n = rem;
        }
        return m;
    }

}
