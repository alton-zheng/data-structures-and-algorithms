package java01109.m02;

/**
 * @Author: alton
 * @Date: Created in 2021/8/31 8:30 上午
 * @Description:
 * Runtime: 3 ms, faster than 67.99% of Java online submissions for Corporate Flight Bookings.
 * Memory Usage: 103.3 MB, less than 6.88% of Java online submissions for Corporate Flight Bookings.
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];

        for (int[] booking: bookings) {

            res[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                res[booking[1]] -= booking[2];
            }

        }

        for (int i = 1; i < n; i++) {
            res[i] += res[i - 1];
        }

        return res;
    }
}