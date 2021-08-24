package java00069.m03;

/**
 * @Author: alton
 * @Date: Created in 2021/8/24 9:10 下午
 * @Description:
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Sqrt(x).
 * Memory Usage: 36.3 MB, less than 23.91% of Java online submissions for Sqrt(x).
 */
class Solution {
    public int mySqrt(int x) {

        int left = 0, right = x, res = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if ((long)mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}