/**
 * @Author: alton
 * @Date: Created in 5/29/21 8:52 AM
 * @Description:
 * 560. Subarray Sum Equals K #54
 *
 * Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals to k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * Runtime: 72 ms, faster than 73.66% of C++ online submissions for Subarray Sum Equals K.
   Memory Usage: 36 MB, less than 96.79% of C++ online submissions for Subarray Sum Equals K.
 * preSum[i] - preSum[j - 1] = k
 */
class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {

        int preSum = 0, res = 0;
        unordered_map<int, int> help;

        help[0] = 1;

        for (int num : nums) {
            preSum += num;
            if (help.count(preSum - k)){
                res += help[preSum - k];
            }
            help[preSum]++;
        }

        return res;
    }
};