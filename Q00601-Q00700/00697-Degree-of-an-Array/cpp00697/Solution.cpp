class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
      unordered_map<int, vector<int>> mp;
        int number = 0;

    for (int i = 0; i < nums.size(); i++) {
        if (!mp.count(nums[i])) {
            vector<int> temp(3);
            temp[0] = i;
            temp[1] = i;
            temp[2] = 0;
            mp[nums[i]] = temp;
        } else {
            mp[nums[i]][1] = i;
            mp[nums[i]][2] = mp[nums[i]][2] + 1;
        }

        number = max(number, mp[nums[i]][2]);

    }

    int res = 50000;

    for (auto& [_, value] : mp) {
        if (number == value[2]) {
            res = min(res, value[1] - value[0] + 1);
        }
    }

    return res;
    }
};