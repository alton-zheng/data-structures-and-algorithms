class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int numsLen = nums.size();
        sort(nums.begin(), nums.end());
        vector<vector<int>> ans;

        for (int first = 0; first < numsLen; ++first) {

            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int third = numsLen - 1;
            int target = -nums[first];

            for (int second = first + 1; second < numsLen; ++second) {

                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }

                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }

                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    ans.push_back({nums[first], nums[second], nums[third]});
                }
            }
        }
        return ans;
    }
};