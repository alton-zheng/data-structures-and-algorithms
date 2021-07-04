// Runtime: 24 ms, faster than 91.03% of C++ online submissions for Set Mismatch.
// Memory Usage: 22.2 MB, less than 48.03% of C++ online submissions for Set Mismatch.
class Solution {
public:
    vector<int> findErrorNums(vector<int>& nums) {
        vector<int> help(nums.size() + 1);

        for (int num: nums) {
            help[num]++;
        }

        vector<int> res(2);
        int flag = 0;
        for (int i = 1; i <= nums.size(); i++) {
            if (help[i] == 2) {
                res[0] = i;
                flag++;
            }

            if (help[i] == 0) {
                res[1] = i;
                flag++;
            }

            if (flag == 2) {
                return res;
            }
        }

        return {-1,-1};
    }
};