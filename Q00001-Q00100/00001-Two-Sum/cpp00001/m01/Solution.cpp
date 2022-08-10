class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> help;

        for (int i = 0; i < nums.size(); i++) {
            if (help.count(nums[i])) {
                return {help[nums[i]], i};
            }

            help[target - nums[i]] = i;
        }

        return {-1, -1};

    }

};