// Runtime: 552 ms, faster than 11.85% of C++ online submissions for Valid Triangle Number.
// Memory Usage: 12.9 MB, less than 24.59% of C++ online submissions for Valid Triangle Number.
class Solution {
public:
    int triangleNumber(vector<int>& nums) {

        int len = nums.size();

        sort(nums.begin(), nums.end());

        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int left = j, right = len - 1, k = j;

                while (left <= right) {
                    int mid = left + ((right - left) >> 1);

                    if (nums[i] + nums[j] > nums[mid]) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                res += k - j;
            }
        }

        return res;
    }
};