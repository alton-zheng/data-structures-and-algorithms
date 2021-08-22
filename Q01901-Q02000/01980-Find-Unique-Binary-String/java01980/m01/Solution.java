package java01980.m01;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: alton
 * @Date: Created in 2021/8/22 下午8:19
 * @Description:
 * 1980. Find Unique Binary String
 *
 * Given an array of strings nums containing n unique binary strings each of length n, return a binary string of length n that does not appear in nums. If there are multiple answers, you may return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = ["01","10"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "00" would also be correct.
 * Example 2:
 *
 * Input: nums = ["00","01"]
 * Output: "11"
 * Explanation: "11" does not appear in nums. "10" would also be correct.
 * Example 3:
 *
 * Input: nums = ["111","011","001"]
 * Output: "101"
 * Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 16
 * nums[i].length == n
 * nums[i] is either '0' or '1'.
 *
 */
class Solution {
    Map<String, Integer> help;
    int len = 0;
    String res = "";
    public String findDifferentBinaryString(String[] nums) {

        help = new HashMap<>();

        len = nums.length;
        for (int i = 0; i < len; i++) {
            help.put(nums[i], 0);
        }

        dfs(0, "");
        return res;
    }

    private void dfs(int start, String value)  {

        if (start == len) {
            if (!help.containsKey(value)) {
                res = value;
            }

            return;

        }

        if ("".equals(res) && start < len) {
            dfs (start + 1, value + "0");
        }


        if ("".equals(res) && start < len) {
            dfs(start + 1, value + "1");
        }


    }
}
