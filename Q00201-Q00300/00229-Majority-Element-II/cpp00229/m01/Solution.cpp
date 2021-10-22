class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int len = nums.size();
        vector<int> ans;
        unordered_map<int, int> cnt;

        for (auto& num : nums) {
            cnt[num]++;
        }

        for (auto& c: cnt) {
            if (c.second > len / 3) {
                ans.push_back(c.first);
            }
        }

        return ans;
    }
};