package java00078.m01;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 7/10/21 4:48 PM
 * @Description:
 * 78. Subsets #192
 *
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 *
 * Time Complexity : O(n*n^2)
 * Space Complexity ： O(n)
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Subsets.
 * Memory Usage: 38.9 MB, less than 94.13% of Java online submissions for Subsets.
 *
 */
class Solution {


    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i < 1 << n ; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }

            res.add(subset);
        }

        return res;
    }

    public static void main(String[] args) {
        new Solution().subsets(new int[]{1,2,3});
    }
}
