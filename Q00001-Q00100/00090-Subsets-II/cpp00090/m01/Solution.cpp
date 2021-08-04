// Runtime: 4 ms, faster than 76.22% of C++ online submissions for Subsets II.
// Memory Usage: 7.3 MB, less than 94.99% of C++ online submissions for Subsets II.
class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> temp;

        sort(nums.begin(), nums.end());

        int len = nums.size();

        for (int m = 0; m < (1 << len); m++) {
            temp.clear();

            int flag = 1;
            for (int i = 0; i < len; i++) {

                if ((m & (1 << i)) != 0) {
                    if (i > 0 && (m >> (i - 1) & 1) == 0 && nums[i] == nums[i - 1] ) {
                        flag = 0;
                        break;
                    }

                    temp.push_back(nums[i]);

                }

            }

            if (flag == 1) {
                res.push_back(temp);
            }
        }

        return res;
    }
};