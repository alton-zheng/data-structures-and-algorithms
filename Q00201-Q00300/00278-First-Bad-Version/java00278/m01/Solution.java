package java00278.m01;

import java00278.VersionControl;

/**
 * @Author: alton
 * @Date: Created in 6/13/21 6:04 AM
 * @Description:
 *
 * 278. First Bad Version #105
 *
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 *
 * Input: n = 1, bad = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= bad <= n <= 231 - 1
 *
 * Time Complexity :O(logn)
 * Space Complexity : O(1)
 *
 * Runtime: 12 ms, faster than 98.35% of Java online submissions for First Bad Version.
 * Memory Usage: 35.7 MB, less than 44.59% of Java online submissions for First Bad Version.
 */
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int left = 1, right = n;
        int search = 0;
        while (left < right) {
            search = (right - left) / 2 + left;
            if (isBadVersion(search)) {
                right = search;
            } else {
                left = search + 1;
            }
        }

        return left;
    }
}
