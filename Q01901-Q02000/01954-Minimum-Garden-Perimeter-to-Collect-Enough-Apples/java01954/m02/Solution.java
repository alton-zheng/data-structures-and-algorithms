package java01954.m02;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Garden Perimeter to Collect Enough Apples.
 * Memory Usage: 35.7 MB, less than 66.67% of Java online submissions for Minimum Garden Perimeter to Collect Enough Apples.
 *
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */
class Solution {
    public long minimumPerimeter(long neededApples) {
        
        long left = 1, right = 100000;
        long l = 0;
        
        while (left <= right) {
            long mid = left + ((right - left) >> 1);
            if (2 * mid * (mid + 1) * (2*mid + 1) >= neededApples) {
                l = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return 8 * l;
        
    }
}