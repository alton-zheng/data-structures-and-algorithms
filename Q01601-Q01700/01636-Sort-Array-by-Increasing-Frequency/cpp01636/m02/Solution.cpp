// Runtime: 0 ms, faster than 100.00% of C++ online submissions for Sort Array by Increasing Frequency.
// Memory Usage: 10.9 MB, less than 96.06% of C++ online submissions for Sort Array by Increasing Frequency.
class Solution {
public:
    vector<int> frequencySort(vector<int>& nums) {

        vector<int> cnt(201);
        for (auto n : nums) {
            cnt[n + 100]++;
        }

        sort(nums.begin(), nums.end(), [&](int a, int b) {
            return cnt[a + 100] == cnt[b + 100] ? a > b : cnt[a + 100] < cnt[b + 100];
        });
        return nums;
    }
};