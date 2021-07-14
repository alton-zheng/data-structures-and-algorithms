// Runtime: 148 ms, faster than 96.46% of C++ online submissions for Minimum Absolute Sum Difference.
// Memory Usage: 63.9 MB, less than 90.10% of C++ online submissions for Minimum Absolute Sum Difference.
class Solution {
public:
    int minAbsoluteSumDiff(vector<int>& nums1, vector<int>& nums2) {

        int mod = 1000000007;
        int nums1Len = nums1.size();
        vector<int> help(nums1);
        sort(help.begin(), help.end());

        int sum = 0, m = 0;
        for (int i = 0; i < nums1Len; i++) {
            int diff = abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % mod;

            int j = bs(help, nums2[i]);

            if (j < nums1Len) {
                m = max(m, diff - (help[j] - nums2[i]));
            }

            if (j > 0) {
                m = max(m, diff - (nums2[i] - help[j - 1]));
            }

        }
        return (sum - m + mod) % mod;
    }

private:
    int bs(vector<int>& help, int target) {
        int left = 0, right = help.size() - 1;
        if (help[right] < target) {
            return right + 1;
        }

        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (help[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
};