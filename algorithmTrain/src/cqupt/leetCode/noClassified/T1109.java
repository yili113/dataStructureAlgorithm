package cqupt.leetCode.noClassified;

/**
 * @author Liyi
 * @create 2020-03-25 14:01
 * 航班预订统计
 */
public class T1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int left = bookings[i][0];
            int right = bookings[i][1];
            int nums = bookings[i][2];
            for (int j = left; j <= right; j++) {
                res[j - 1] += nums;
            }
        }
        return res;
    }
}
