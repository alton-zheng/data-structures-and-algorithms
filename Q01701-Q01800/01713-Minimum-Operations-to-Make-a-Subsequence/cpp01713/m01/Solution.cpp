// Runtime: 308 ms, faster than 70.82% of C++ online submissions for Minimum Operations to Make a Subsequence.
// Memory Usage: 109.8 MB, less than 82.62% of C++ online submissions for Minimum Operations to Make a Subsequence.
class Solution {
public:
    int minOperations(vector<int> &target, vector<int> &arr) {
        int n = target.size();
        unordered_map<int, int> help;
        for (int i = 1; i <= n; ++i) {
            help[target[i - 1]] = i;
        }
        vector<int> d;
        for (int val : arr) {
            if (help.count(val)) {
                int idx = help[val];
                auto it = lower_bound(d.begin(), d.end(), idx);
                if (it != d.end()) {
                    *it = idx;
                } else {
                    d.push_back(idx);
                }
            }
        }
        return n - d.size();
    }
};