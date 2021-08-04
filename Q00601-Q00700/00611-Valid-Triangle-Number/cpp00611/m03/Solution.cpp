// Runtime: 124 ms, faster than 45.21% of C++ online submissions for Valid Triangle Number.
// Memory Usage: 12.9 MB, less than 7.91% of C++ online submissions for Valid Triangle Number.
class Solution {
public:
    int triangleNumber(vector<int>& nums) {

        int len = nums.size();

        sort(nums.begin(), nums.end());

        int res = 0;
        for (int i = 0; i < len; i++) {
            int k = i;

            for (int j = i + 1; j < len; j++) {
                while (k + 1 < len && nums[i] + nums[j] > nums[k + 1]) {
                    k++;
                }
               res += max(k - j, 0);
            }
        }

        return res;
    }
};