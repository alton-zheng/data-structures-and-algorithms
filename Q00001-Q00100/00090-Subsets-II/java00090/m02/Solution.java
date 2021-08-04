package java00090.m02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: alton
 * @Date: Created in 2021/8/4 1:27 下午
 * @Description:
 *
 * 90. Subsets II #271
 *
 * Runtime: 2 ms, faster than 39.69% of Java online submissions for Subsets II.
 * Memory Usage: 39.2 MB, less than 58.74% of Java online submissions for Subsets II.
 *
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2]
 * Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
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
 *
 * Time Complexity: O(n * 2^n)
 * Space Complexity: O(N)
 *
 */
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);

        for (int m = 0; m < (1 << len); m++) {

            temp.clear();
            int flag = 1;

            for (int i = 0; i < len; i++) {
                if (((1 << i) & m) != 0) {
                    if (i > 0 && (m >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1]) {
                        flag = 0;
                        break;
                    }

                    temp.add(nums[i]);
                }
            }

            if (flag == 1) {
                res.add(new ArrayList<>(temp));
            }
        }

        return res;

    }
}
