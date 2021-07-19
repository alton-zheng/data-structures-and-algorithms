// Runtime: 204 ms, faster than 67.82% of C++ online submissions for Frequency of the Most Frequent Element.
// Memory Usage: 99.1 MB, less than 24.21% of C++ online submissions for Frequency of the Most Frequent Element.
class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int res = 1;
        long long preSum = 0;
        for (int left = 0, right = 0; right < nums.size(); right++) {
            preSum += nums[right];
            while (preSum + k < (long)nums[right] * (right - left + 1)) {
                preSum -= nums[left++];
            }

            res = max(res, right - left + 1);
        }

        return res;
    }
};