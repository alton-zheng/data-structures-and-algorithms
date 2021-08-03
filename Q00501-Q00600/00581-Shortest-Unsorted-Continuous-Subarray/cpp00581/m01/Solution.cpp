// Runtime: 28 ms, faster than 76.73% of C++ online submissions for Shortest Unsorted Continuous Subarray.
// Memory Usage: 26.5 MB, less than 89.37% of C++ online submissions for Shortest Unsorted Continuous Subarray.
class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        int len = nums.size();

        int left = -1, right = -1;

        int mi = 100001, ma = -100001;

        for (int i = 0; i < nums.size(); i++) {

            if (ma > nums[i]) {
                right = i;
            } else {
                ma = nums[i];
            }

            if (mi < nums[len - i - 1]) {
                left = len - i - 1;
            } else {
                mi = nums[len - i - 1];
            }

        }

        return left == -1 ? 0 : right - left + 1;
    }
};