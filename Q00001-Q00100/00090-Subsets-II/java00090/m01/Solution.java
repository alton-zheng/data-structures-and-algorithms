package java00090.m01;

import java.util.ArrayList;
import java.util.Arrays;
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
 * Runtime: 1 ms, faster than 99.64% of Java online submissions for Subsets II.
 * Memory Usage: 39.3 MB, less than 58.74% of Java online submissions for Subsets II.
 */
class Solution {

    private List<List<Integer>> res;
    private List<Integer> temp;
    private int len;
    private int[] nums;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        temp = new ArrayList<>();

        len = nums.length;
        Arrays.sort(nums);

        this.nums = nums;

        dfs(false, 0);

        return res;
    }

    private void dfs(boolean isSelect, int idx) {
        if (idx == len) {
            res.add(new ArrayList<>(temp));
            return;
        }

        dfs(false, idx + 1);
        if (!isSelect && idx > 0 && nums[idx] == nums[idx - 1]) {
            return;
        }

        temp.add(nums[idx]);

        dfs(true, idx + 1);

        temp.remove(temp.size() - 1);

    }
}

