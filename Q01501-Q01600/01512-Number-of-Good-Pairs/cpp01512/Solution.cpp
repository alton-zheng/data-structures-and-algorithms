class Solution {
public:
    int numIdenticalPairs(vector<int>& nums) {
        unorder_map <int, int> unorder_map;

        for (int num: nums) {
            unorder_map[num]++;
        }

        int res;

        for (const auto &[k,v]: unorder_map) {
            res += v * (v - 1)/2;
        }

        return res;
    }
};