package java00881.m01;

import java.util.Arrays;

/**
 * @Author: alton
 * @Date: Created in 7/15/21 8:32 PM
 * @Description:
 * 00881-Boats-to-Save-People
 *
 * You are given an array people where people[i] is the weight of the ith person, and an infinite number of boats where each boat can carry a maximum weight of limit. Each boat carries at most two people at the same time, provided the sum of the weight of those people is at most limit.
 *
 * Return the minimum number of boats to carry every given person.
 *
 *
 *
 * Example 1:
 *
 * Input: people = [1,2], limit = 3
 * Output: 1
 * Explanation: 1 boat (1, 2)
 * Example 2:
 *
 * Input: people = [3,2,2,1], limit = 3
 * Output: 3
 * Explanation: 3 boats (1, 2), (2) and (3)
 * Example 3:
 *
 * Input: people = [3,5,3,4], limit = 5
 * Output: 4
 * Explanation: 4 boats (3), (3), (4), (5)
 *
 *
 * Constraints:
 *
 * 1 <= people.length <= 5 * 104
 * 1 <= people[i] <= limit <= 3 * 104
 *
 * Time Complexity : O(N*logN)
 * Space Complexity : O(1)
 * Runtime: 13 ms, faster than 95.45% of Java online submissions for Boats to Save People.
 * Memory Usage: 47.6 MB, less than 91.78% of Java online submissions for Boats to Save People.
 *
 */
class Solution {
    public int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);

        int res = 0;
        // 由于最重的人只会小于等于船的限重，所以
        int left = 0, right = people.length - 1;

        // 由于 people 可能为单数个人，所以 left = right 的情况也要考虑进去
        while (left <= right) {
            res++;
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numRescueBoats(new int[]{1, 2, 3, 6}, 6));
    }
}
